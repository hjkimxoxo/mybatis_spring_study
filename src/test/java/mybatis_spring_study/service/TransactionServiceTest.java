package mybatis_spring_study.service;

import static org.junit.Assert.fail;

import java.sql.SQLException;

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

import mybatis_spring_study.dto.Department;
import mybatis_spring_study.dto.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/context-root.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TransactionServiceTest {
	protected static final Log log= LogFactory.getLog(TransactionServiceTest.class);

	@Autowired
	private TransactionService service;
	
	@After
	public void tearDown() throws Exception {
	   System.out.println();
	}
	
	@Test(expected = DuplicateKeyException.class)
	public void test1RegisterTransaction_Dept_Fail() throws SQLException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(1, "테스크포스", 10);
		Employee employee = new Employee(1004, "박신혜", "3", new Employee(4377), 4100000, department);
		service.registerTransaction(department, employee);
		//expected 나오면 파란색됨
		
	}
	
	@Test(expected = RuntimeException.class)
	public void test2RegisterTransaction_Emp_Fail() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(5, "테스크포스", 10);
		Employee employee = new Employee(1003, "박신혜", "3", new Employee(4377), 4100000, department);
		service.registerTransaction(department, employee);
	}
	@Test
	public void test3RegisterTransaction_Success() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(5, "테스크포스", 10);
		Employee employee = new Employee(1004, "박신혜", "3", new Employee(4377), 4100000, department);
		service.registerTransaction(department, employee);
	}

	@Test
	public void testUnRegisterTransaction() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(5);
		Employee employee = new Employee(1004);
		service.unRegisterTransaction(department, employee);
	}

}
