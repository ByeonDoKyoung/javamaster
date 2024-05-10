package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.EmployeeVO;

public interface EmpMapper {
	List<EmpMapper> selectEmp();
	int insertEmp(EmployeeVO evo);
	int deleteEmp(int employeeId);
	EmployeeVO getEmployee(int employeeId);
	
}
