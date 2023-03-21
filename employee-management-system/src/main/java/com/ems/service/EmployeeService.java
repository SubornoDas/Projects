package com.ems.service;

import com.ems.entity.Employee;
import com.ems.model.EmployeeDTO;

public interface EmployeeService {
	void saveEmployee(Employee employee);
	EmployeeDTO getEmployeeUsingId(int id);
	EmployeeDTO updateEmployeeById(int id,Employee employee);
	void deleteEmployeeById(int id);
	EmployeeDTO getEmployeeByEmail(String email);
	boolean login(String userName,String password);
	
	
}
