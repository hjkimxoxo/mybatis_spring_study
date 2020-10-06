package mybatis_spring_study.mapper;

import static org.junit.Assert.*;

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


import mybatis_spring_study.config.ContextRoot;
import mybatis_spring_study.dto.Department;
import mybatis_spring_study.dto.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class} )
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EmployeeMapperTest {
	protected static final Log log = LogFactory.getLog(EmployeeMapperTest.class);
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Autowired
	private EmployeeMapper dao;
	

	//@Test
	public void testInsertEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee emp = new Employee(1219, "김혜진", "5", new Employee(4377), 2000000, new Department(3));
		int res = dao.insertEmployee(emp);
		Assert.assertEquals(1, res);
	}

	@Test
	public void testDeleteEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee emp = new Employee(1219);
		int res = dao.deleteEmployee(emp);
		Assert.assertEquals(1, res);
		
	}

}
