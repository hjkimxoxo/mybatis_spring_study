package mybatis_spring_study.mapper;

import static org.junit.Assert.fail;

import java.util.List;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class} )
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DepartmentMapperTest {
	protected static final Log log = LogFactory.getLog(DepartmentMapperTest.class);

	
	@After
	public void tearDown() throws Exception {
		System.out.println();

	}

	@Autowired
	private DepartmentMapper dao;

	
	@Test
	public void test01SelectDepartmentByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Department> list = dao.selectDepartmentByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);

	}

	@Test
	public void test02SelectDepartmentByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department dept = dao.selectDepartmentByNo(new Department(1));
		Assert.assertNotNull(dept);
		System.out.println(dept);
	}
	
	
	//@Test
	public void test03InsertDepartment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department dept =  new Department(5, "마케팅", 11);
		int res = dao.insertDepartment(dept);
		Assert.assertEquals(1, res);
		System.out.println("--확인--");
		List<Department> list = dao.selectDepartmentByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		
		
	}

	//@Test
	public void test04UpdateDepartment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department dept = dao.selectDepartmentByNo(new Department(5));
		dept.setDeptName("마케팅변경");
		dept.setFloor(12);
		int res = dao.updateDepartment(dept);
		Assert.assertEquals(1, res);
		
	}
	
	//@Test
	public void test05DeleteDepartment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department dept = dao.selectDepartmentByNo(new Department(5));
		int res = dao.deleteDepartment(dept);
		Assert.assertEquals(1, res);
		System.out.println("--확인--");
		List<Department> list = dao.selectDepartmentByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		
	}

}
