package com.ems.serviceimpl;

import org.modelmapper.ModelMapper;

import com.ems.DAO.DepartmentDAO;
import com.ems.daoimpl.DepartmentDAOImpl;
import com.ems.entity.Department;
import com.ems.exception.GlobalException;
import com.ems.model.DepartmentDTO;
import com.ems.service.DepartmentService;

public class DepartmentserviceImpl implements DepartmentService {

	//accessing all the data access layer(DAO) to call the methods
	DepartmentDAO deptDAO=new DepartmentDAOImpl(); 
		

	@Override
	public void saveDepartment(Department dept) {
		deptDAO.saveDepartment(dept);
		
	}

	@Override
	public DepartmentDTO getDepartmentUsingId(int id) {
		Department department=deptDAO.getDepartmentUsingId(id);
		if(department!=null) {
			return new ModelMapper().map(department, DepartmentDTO.class);
			}
		else {
			throw new GlobalException("Employee details not found !!");
		}
		
	}

	@Override
	public void assignEmployeeToDept(int employeeId, int deptId) {
		deptDAO.assignEmployeeToDept(employeeId,deptId);
		
	}

	@Override
	public DepartmentDTO updateDepartmentUsingId(int id, Department dept) {
	Department dept1=deptDAO.updateDepartmentUsingId(id, dept);
	if(dept1!=null) {
	return new ModelMapper().map(dept1, DepartmentDTO.class);
		
	}
	else
		throw new GlobalException("DEpartment with id"+id+" not found");
	
	}

	@Override
	public void deleteDepartmentUsingId(int id) {
		deptDAO.deleteDepartmentUsingId(id);
		}

	@Override
	public void assignManagerToDept(int managerId, int deptId) {
		deptDAO.assignManagerToDept(managerId, deptId);
		
	}
	
}
