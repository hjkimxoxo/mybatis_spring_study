package mybatis_spring_study.mapper;

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

import mybatis_spring_study.dto.Department;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/context-root.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DepartmentMapperTest {

	protected static final Log log= LogFactory.getLog(DepartmentMapperTest.class);
	
	@Autowired
	private DepartmentMapper mapper;
	
	@After
	public void tearDown() throws Exception {
	   System.out.println();
	}
	
	@Test
	public void test01SelectDepartmentAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Department> list = mapper.selectDepartmentAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);

	}

	@Test
	public void test02SelectDepartmentByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department dept = mapper.selectDepartmentByNo(new Department(1));
		Assert.assertNotNull(dept);
		log.debug(dept.toString());
		System.out.println(dept);
	}

	@Test
	public void test03InsertDepartment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department dept = new Department(11, "마케팅6", 12);
		int res = mapper.insertDepartment(dept);
		Assert.assertEquals(1, res);
		
	}

	@Test
	public void test04UpdateDepartment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department dept = mapper.selectDepartmentByNo(new Department(11));
		dept.setDeptName("마케팅66");
		dept.setFloor(20);
		int res = mapper.updateDepartment(dept);
		Assert.assertEquals(1, res);
		
	}

	@Test
	public void test05DeleteDepartment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department dept = mapper.selectDepartmentByNo(new Department(11));
		int res = mapper.deleteDepartment(dept);
		Assert.assertEquals(1, res);
	}

}
