package com.ems;

import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ems.entity.Department;
import com.ems.exception.GlobalException;
import com.ems.model.DepartmentDTO;
import com.ems.service.DepartmentService;
import com.ems.serviceimpl.DepartmentserviceImpl;

public class DepartmentCRUD {
static Scanner sc=new Scanner(System.in);
static DepartmentService deptService=new DepartmentserviceImpl();
public static void addDepartment() {
	Department dept=new Department();
	
	String deptName=JOptionPane.showInputDialog("Enter Department name:","Type here..");
	Integer totalEmp=Integer.parseInt(JOptionPane.showInputDialog("Enter Total Employee:","Type here.."));
	String location=JOptionPane.showInputDialog("enter Department location:","Type here...");
	
	dept.setDeptName(deptName);
	dept.setTotalEmp(totalEmp);
	dept.setLocation(location);
	
	deptService.saveDepartment(dept);
	System.out.println("Department details saved..");
}
public static void getDepartment() throws GlobalException{
	int deptId=Integer.parseInt(JOptionPane.showInputDialog("Enter id to search:","Type here.."));
	DepartmentDTO dept=deptService.getDepartmentUsingId(deptId);
	
	System.out.println("Department Name:"+dept.getDeptName());
	System.out.println("Department Total Employee:"+dept.getTotalEmp());
	System.out.println("Department location: "+dept.getLocation());
		System.out.println("=============================");
}
public static void updateDepartmentUsingId() throws GlobalException{
	int id=Integer.parseInt(JOptionPane.showInputDialog("Enter id to update:","Type here.."));
	Department dept1=new Department();
	String deptName=JOptionPane.showInputDialog("Enter Department name:","Type here..");
	Integer totalEmp=Integer.parseInt(JOptionPane.showInputDialog("Enter Total Employee:","Type here.."));
	String location=JOptionPane.showInputDialog("enter Department location:","Type here...");

	dept1.setDeptName(deptName);
	dept1.setTotalEmp(totalEmp);
	dept1.setLocation(location);
	deptService.updateDepartmentUsingId(id, dept1);
	System.out.println("Department details updated successfully");
}
public static void deleteDepartmentUsingId() {
	int id=Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete :","Type here.."));
	deptService.deleteDepartmentUsingId(id);
	JOptionPane.showMessageDialog(null, "Object is deleted !!");
}
public static void assignEmployeeToDepartment() {
	int deptId=Integer.parseInt(JOptionPane.showInputDialog("Enter dept. id:","Type here.."));
	int empId=Integer.parseInt(JOptionPane.showInputDialog("Enter employee id:","Type here.."));
	deptService.assignEmployeeToDept(empId, deptId);
	JOptionPane.showMessageDialog(null, "Employee has been assigned successfully!!");
	
}

public static void assignMgrToDept() {
	int deptId=Integer.parseInt(JOptionPane.showInputDialog("Enter dept. id:","Type here.."));
	int mgrId=Integer.parseInt(JOptionPane.showInputDialog("Enter manager id:","Type here.."));
	deptService.assignManagerToDept(mgrId, deptId);
	JOptionPane.showMessageDialog(null, "Manager has been assigned successfully!!");
	
}
}
