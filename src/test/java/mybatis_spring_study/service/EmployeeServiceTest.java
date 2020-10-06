package mybatis_spring_study.service;

import static org.junit.Assert.fail;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mybatis_spring_study.dto.Department;
import mybatis_spring_study.dto.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/context-root.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EmployeeServiceTest {
	protected static final Log log= LogFactory.getLog(EmployeeServiceTest.class);
	
	@Autowired
	private EmployeeService service;
	
	@After
	public void tearDown() throws Exception {
	   System.out.println();
	}
	
	//@Test
	public void test01AddEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee emp = new Employee(1000, "김혜진2", "5", new Employee(4377), 2500000, new Department(3));
		int res = service.addEmployee(emp);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test02DelEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee emp = service.selectEmployeeByNo(new Employee(1219));
		int res = service.delEmployee(emp);
		Assert.assertEquals(1, res);
	}

}
