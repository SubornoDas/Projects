package com.ems;

import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.EmployeeDTO;
import com.ems.service.EmployeeService;
import com.ems.serviceimpl.EmployeeServiceImpl;

public class EmployeeCRUD {
static Scanner sc=new Scanner(System.in);
static EmployeeService empService=new EmployeeServiceImpl();

public static void saveEmployee() {
	Employee emp=new Employee();
//	sc.nextLine();
//	System.out.println("Enter name : ");
//	String name=sc.nextLine();
//	System.out.println("Enter address : ");
//	String add=sc.nextLine();
//	System.out.println("Enter salary : ");
//	double sal=sc.nextDouble();
//	System.out.println("Enter contact no : ");
//	String cont=sc.next();
//	sc.nextLine();
//	System.out.println("Enter email : ");
//	String email=sc.nextLine();
//	System.out.println("Enter designation : ");
//	String des=sc.nextLine();
//	System.out.println("Enter DOJ : ");
//	LocalDate date=LocalDate.parse(sc.next());  //yyyy-mm-dd
//	System.out.println("Enter username : ");
//	String user=sc.nextLine();
//	sc.nextLine();
//	System.out.println("Enter password : ");
//	String pass=sc.nextLine();
	
	
	String name=JOptionPane.showInputDialog("Enter name:","Type here..");
	String add=JOptionPane.showInputDialog("Enter address:","Type here..");
	Double sal=Double.parseDouble(JOptionPane.showInputDialog("Enter Salary:","Type here.."));
	String cont=JOptionPane.showInputDialog("Enter contact number:","Type here..");
	String email=JOptionPane.showInputDialog("Enter email:","Type here..");
	String des=JOptionPane.showInputDialog("Enter designation:","Type here..");
	LocalDate date=LocalDate.parse(JOptionPane.showInputDialog("Enter date:","Type here.."));
	String user=JOptionPane.showInputDialog("Enter user-name:","Type here..");
	String pass=JOptionPane.showInputDialog("Enter password:","Type here..");
	
	
	emp.setEmpName(name);
	emp.setEmpAddress(add);
	emp.setSalary(sal);
	emp.setContact(cont);
	emp.setEmail(email);
	emp.setDesignation(des);
	emp.setDOJ(date);
	emp.setUserName(user);
	emp.setPassword(pass);
	emp.setRole("employee");
	
	empService.saveEmployee(emp);
	System.out.println("Employee details saved");
}

public static void getEmployeeById() throws GlobalException{

	int id=Integer.parseInt(JOptionPane.showInputDialog("Enter id to search:","Type here.."));
	EmployeeDTO emp1=empService.getEmployeeUsingId(id);
	System.out.println("Employee Name:"+emp1.getEmpName());
	System.out.println("Employee Address:"+emp1.getEmpAddress());
	System.out.println("Employee salary:"+emp1.getSalary());
	System.out.println("Employee contact number:"+emp1.getContact());
	System.out.println("Employee email:"+emp1.getEmail());
	System.out.println("Employee designation:"+emp1.getDesignation());
	System.out.println("Employee date-of-joining:"+emp1.getDOJ());
	System.out.println("Employee username:"+emp1.getUserName());
	System.out.println("Employee password:"+emp1.getPassword());
	System.out.println("Employee role:"+emp1.getRole());
}
public static void updateEmployee() throws GlobalException{
	Employee emp1=new Employee();
	int id=Integer.parseInt(JOptionPane.showInputDialog("Enter id to update:","Type here.."));
	String name=JOptionPane.showInputDialog("Enter name:","Type here..");
	String add=JOptionPane.showInputDialog("Enter address:","Type here..");
	Double sal=Double.parseDouble(JOptionPane.showInputDialog("Enter Salary:","Type here.."));
	String cont=JOptionPane.showInputDialog("Enter contact number:","Type here..");
	String email=JOptionPane.showInputDialog("Enter email:","Type here..");
	String des=JOptionPane.showInputDialog("Enter designation:","Type here..");
	LocalDate date=LocalDate.parse(JOptionPane.showInputDialog("Enter date:","Type here.."));
	String user=JOptionPane.showInputDialog("Enter user-name:","Type here..");
	String pass=JOptionPane.showInputDialog("Enter password:","Type here..");
	
	
	emp1.setEmpName(name);
	emp1.setEmpAddress(add);
	emp1.setSalary(sal);
	emp1.setContact(cont);
	emp1.setEmail(email);
	emp1.setDesignation(des);
	emp1.setDOJ(date);
	emp1.setUserName(user);
	emp1.setPassword(pass);
	//emp1.setRole("employee");
	empService.updateEmployeeById(id, emp1);
	//empService.updateEmployeeById(Integer.parseInt(
			//JOptionPane.showInputDialog("Enter id to update:","Type here..")),emp1);
	System.out.println("Employee details updated successfully !!!");
}

public static void deleteEmployee() {
	int id=Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete :","Type here.."));
	empService.deleteEmployeeById(id);
	JOptionPane.showMessageDialog(null, "Object is deleted !!");
}

public static void getEmployeeByEmail() {
	String email=JOptionPane.showInputDialog("Enter email:","Type here..");
	EmployeeDTO emps=empService.getEmployeeByEmail(email);
	
	System.out.println("Employee Name:"+emps.getEmpName());
	System.out.println("Employee Address:"+emps.getEmpAddress());
	System.out.println("Employee salary:"+emps.getSalary());
	System.out.println("Employee contact number:"+emps.getContact());
	System.out.println("Employee email:"+emps.getEmail());
	System.out.println("Employee designation:"+emps.getDesignation());
	System.out.println("Employee date-of-joining:"+emps.getDOJ());
	
}
public static void login() {
	empService.login(JOptionPane.showInputDialog("Enter user_name:","Type here.."), JOptionPane.showInputDialog("Enter password:","Type here.."));
	
}
public static void afterLoginEmployee() {
	System.out.println();
	
	System.out.println("A) To fetch employee details using id\nB) To fetch employee details using email\nC) To update own details");
	
	String choice=JOptionPane.showInputDialog("Enter choice:","Type here...");
	switch(choice) {
	case "A":
		getEmployeeById();
		break;
	case "B":
		getEmployeeByEmail();
		break;
	case "C":
		updateEmployee();
		break;
	}
}
}









