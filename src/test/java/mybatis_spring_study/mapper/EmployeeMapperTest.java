package mybatis_spring_study.mapper;

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
public class EmployeeMapperTest {

	protected static final Log log= LogFactory.getLog(EmployeeMapperTest.class);
	
	@Autowired
	private EmployeeMapper mapper;
	
	@After
	public void tearDown() throws Exception {
	   System.out.println();
	}
	
	@Test
	public void test01InsertEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee emp = new Employee(1212, "김혜진", "5", new Employee(4377), 2000000, new Department(3));
		int res = mapper.insertEmployee(emp);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test02DeleteEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee emp = mapper.selectEmployeeByNo(new Employee(1212));
		int res = mapper.deleteEmployee(emp);
		Assert.assertEquals(1, res);
	}
	
	@Test 
	public void test03SelectEmployeeByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee emp = mapper.selectEmployeeByNo(new Employee(4377));
		Assert.assertNotNull(emp);
		System.out.println(emp);
	}

}
