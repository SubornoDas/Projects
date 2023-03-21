package com.ems.service;

import com.ems.entity.Department;
import com.ems.model.DepartmentDTO;

public interface DepartmentService {
	
void saveDepartment(Department department);
DepartmentDTO getDepartmentUsingId(int id);
DepartmentDTO updateDepartmentUsingId(int id,Department deptt);
void deleteDepartmentUsingId(int id);
void assignEmployeeToDept(int employeeId,int deptId);
void assignManagerToDept(int managerId, int deptId);
}
