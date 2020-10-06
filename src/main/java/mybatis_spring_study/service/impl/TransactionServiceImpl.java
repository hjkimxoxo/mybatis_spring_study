package mybatis_spring_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mybatis_spring_study.dto.Department;
import mybatis_spring_study.dto.Employee;
import mybatis_spring_study.mapper.DepartmentMapper;
import mybatis_spring_study.mapper.EmployeeMapper;
import mybatis_spring_study.service.TransactionService;

@Service //contextroot에 패키지명시-> 애노테이션 해준것만 적용
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private DepartmentMapper deptMapper;
	
	@Autowired 
	private EmployeeMapper empMapper;
	
	@Override
	@Transactional
	public void trRegister(Department department, Employee employee) {
		//부서가 등록되고난 후 해당 부서에 사원추가(존재해야만 들어감). 둘다 되거나 안되거나
		deptMapper.insertDepartment(department);
		empMapper.insertEmployee(employee);
	}

	@Override
	@Transactional
	public void trUnRegister(Department department, Employee employee) {
		int res =empMapper.deleteEmployee(employee);
		res += deptMapper.deleteDepartment(department);
		if(res!=2) throw new RuntimeException();
		
	}

}
