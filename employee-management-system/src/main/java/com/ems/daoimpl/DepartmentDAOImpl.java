package com.ems.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ems.DAO.DepartmentDAO;
import com.ems.config.HibernateUtil;
import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.entity.Manager;

public class DepartmentDAOImpl implements DepartmentDAO{

//this method gets the session to save the new department details
	
	public void saveDepartment(Department department) {
	try(Session session=HibernateUtil.getSession()){
		session.beginTransaction();
		// add all the new department details
		session.save(department);
		//java object saved to the database
		session.getTransaction().commit();
		
		//clear the session
		session.clear();
	}
	catch(HibernateException e) {
		System.out.println(e.getMessage());
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
}

@Override
public Department getDepartmentUsingId(int id) {
	try(Session session=HibernateUtil.getSession()){
		Department department=session.get(Department.class, id);
		return department;
	}
	catch(HibernateException e) {
		System.out.println(e.getMessage());
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		
	}
	return null;
}

@Override
public void assignEmployeeToDept(int employeeId, int deptId) {
	try(Session session =HibernateUtil.getSession()){
		Employee emp=session.get(Employee.class, employeeId);
		Department dept=session.get(Department.class, deptId);
		
		List<Employee> employees=new ArrayList<>();
		employees.add(emp);
		
		dept.setEmployees(employees);
		emp.setDept(dept);
		emp.setManager(emp.getDept().getMgr());
		dept.setTotalEmp(dept.getTotalEmp()+1);
		
		session.beginTransaction();
		session.saveOrUpdate(dept);
		
		session.getTransaction().commit();
	}
	catch(HibernateException e) {
		System.out.println(e.getMessage());
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	
}

@Override
public Department updateDepartmentUsingId(int id, Department dept) {

	try(Session session=HibernateUtil.getSession()){
		Department dept1=session.get(Department.class, id);
		// updating existing details with the new one
		dept1.setDeptName(dept.getDeptName());
		dept1.setTotalEmp(dept.getTotalEmp());
		dept1.setLocation(dept.getLocation());
		session.beginTransaction();
		session.saveOrUpdate(dept1);
		session.getTransaction().commit();
		
		return dept1; // returning employee entity
		
	}
	catch(HibernateException e) {
		System.out.println(e.getMessage());
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	return null;
}

@Override
public void deleteDepartmentUsingId(int id) {
	try(Session session=HibernateUtil.getSession()){
		Department dept=session.load(Department.class, id);
		session.beginTransaction();
		int input=JOptionPane.showConfirmDialog(null, "Do you want to delete ?","Are you sure ?",JOptionPane.YES_NO_OPTION);
		if(input==0) {
			session.delete(dept);
			
		}
		else {
			JOptionPane.showConfirmDialog(null,"User wants to retain it !!");
		}
		session.getTransaction().commit();
	
		}
	catch(HibernateException e) {
		System.out.println(e.getMessage());
	}
	
}

@Override
public void assignManagerToDept(int managerId, int deptId) {
	try(Session session=HibernateUtil.getSession())
	{
		Manager man=session.get(Manager.class, managerId);
		Department dept = session.get(Department.class, deptId);
		 
		dept.setMgr(man);
		
		session.beginTransaction();
		session.saveOrUpdate(dept);
		
		session.getTransaction().commit();
	}
	catch(HibernateException e) {
		System.out.println(e.getMessage());
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	
	
}

}
