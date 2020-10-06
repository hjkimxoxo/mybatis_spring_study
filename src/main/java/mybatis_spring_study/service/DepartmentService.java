package mybatis_spring_study.service;

import mybatis_spring_study.dto.Department;

public interface DepartmentService {
	int delDepartment(Department department);
	int addDepartment(Department department);
}
