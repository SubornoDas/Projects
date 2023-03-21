package com.ems.DAO;

import com.ems.entity.Department;

public interface DepartmentDAO {
	
void saveDepartment(Department department);
Department getDepartmentUsingId(int id);
Department updateDepartmentUsingId(int id,Department dept);
void deleteDepartmentUsingId(int id);
void assignEmployeeToDept(int employeeId,int deptId);
void assignManagerToDept(int managerId, int deptId);
}
