package mybatis_spring_study.mapper;

import java.util.List;

import mybatis_spring_study.dto.Employee;

public interface EmployeeMapper {
	//List<Employee> selectEmployeeByAll();
	int insertEmployee(Employee employee);
	int deleteEmployee(Employee employee);
	Employee selectEmployeeByNo(Employee employee);
}
