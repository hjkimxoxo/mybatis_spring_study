package mybatis_spring_study.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybatis_spring_study.dto.Department;
import mybatis_spring_study.mapper.DepartmentMapper;
import mybatis_spring_study.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentMapper mapper;
	
	@Override
	public int delDepartment(Department department) {
		return mapper.deleteDepartment(department);
	}

	@Override
	public int addDepartment(Department department) {
		return mapper.insertDepartment(department);
	}

}
