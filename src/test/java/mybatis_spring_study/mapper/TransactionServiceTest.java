package mybatis_spring_study.mapper;

import static org.junit.Assert.fail;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mybatis_spring_study.config.ContextRoot;
import mybatis_spring_study.dto.Department;
import mybatis_spring_study.dto.Employee;
import mybatis_spring_study.service.TransactionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class} )
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TransactionServiceTest {
	
	protected static final Log log = LogFactory.getLog(TransactionServiceTest.class);
	
	@Autowired
	private TransactionService service;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test(expected = DuplicateKeyException.class)
	public void test01RegisterTransaction_deptFail() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(1, "태스크포스", 10); 
		Employee employee = new Employee(1004, "박신혜", "3", new Employee(4377), 4100000, department);
		service.registerTransaction(department, employee);
	}
	
	@Test(expected = DuplicateKeyException.class)
	public void test02RegisterTransaction_empFail() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(5, "태스크포스", 10); 
		Employee employee = new Employee(1003, "박신혜", "3", new Employee(4377), 4100000, department);
		service.registerTransaction(department, employee);
	}
	
	@Test
	public void test03RegisterTransaction_success() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(5, "태스크포스", 10); 
		Employee employee = new Employee(1004, "박신혜", "3", new Employee(4377), 4100000, department);
		service.registerTransaction(department, employee);
	}

	@Test(expected=RuntimeException.class)
	public void testUnRegisterTransaction() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(5);
		Employee employee = new Employee(1004);
		service.unRegisterTransaction(department, employee);
	}

}
