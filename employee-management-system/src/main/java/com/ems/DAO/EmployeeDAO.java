package com.ems.DAO;

import com.ems.entity.Employee;
import com.ems.model.EmployeeDTO;

public interface EmployeeDAO {
	
void saveEmployee(Employee employee);
Employee getEmployeeUsingId(int id);
Employee updateEmployee(int id,Employee employee);
void deleteEmployeeById(int id);
EmployeeDTO getEmployeeByEmail(String email);
boolean login(String userName,String password);
}
