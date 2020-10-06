package mybatis_spring_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mybatis_spring_study.dto.Department;
import mybatis_spring_study.dto.Employee;
import mybatis_spring_study.mapper.DepartmentMapper;
import mybatis_spring_study.mapper.EmployeeMapper;
import mybatis_spring_study.service.TransactionAOPService;
import mybatis_spring_study.service.TransactionService;

@Service //contextroot에 패키지명시-> 애노테이션 해준것만 적용
public class TransactionAOPServiceImpl implements TransactionAOPService {

	@Autowired
	private DepartmentMapper deptMapper;
	
	@Autowired 
	private EmployeeMapper empMapper;

	@Override
	public void trRegister(Department department, Employee employee) {
		deptMapper.insertDepartment(department);
		empMapper.insertEmployee(employee);
		
	}

	@Override
	public void trUnRegister(Department department, Employee employee) {
		int res =empMapper.deleteEmployee(employee);
		res += deptMapper.deleteDepartment(department);
		if(res!=2) throw new RuntimeException();
		
	}

}
