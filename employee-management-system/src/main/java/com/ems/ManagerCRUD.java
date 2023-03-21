package com.ems;

import java.util.Scanner;
import javax.swing.JOptionPane;

import com.ems.entity.Manager;
import com.ems.exception.GlobalException;
import com.ems.model.ManagerDTO;
import com.ems.service.ManagerService;
import com.ems.serviceimpl.ManagerServiceImpl;

public class ManagerCRUD {
	static Scanner sc=new Scanner(System.in);
static ManagerService mgrService=new ManagerServiceImpl();

public static void saveManager() {
	Manager mgr=new Manager();
	String name=JOptionPane.showInputDialog("Enter name :"," Type here.. ");
	String add=JOptionPane.showInputDialog("Enter address :","Type here..");
	Double sal=Double.parseDouble(JOptionPane.showInputDialog("Enter salary :","Type here.."));
	String cont=JOptionPane.showInputDialog("Enter contact no. :","Type here..");
	String email=JOptionPane.showInputDialog("Enter email :","Type here..");
	String user=JOptionPane.showInputDialog("Enter user name:","Type here..");
	String pass=JOptionPane.showInputDialog("Enter password:","Type here..");
	
	mgr.setMgrName(name);
	mgr.setMgrAddress(add);
	mgr.setSalary(sal);
	mgr.setContact(cont);
	mgr.setEmail(email);
	mgr.setUserName(user);
	mgr.setPassword(pass);
	mgr.setRole("manager");
	
	
	mgrService.saveManager(mgr);
	System.out.println("Manager details saved !!!");
}
public static void assignEmployeeToManager() {
	int empId=Integer.parseInt(JOptionPane.showInputDialog("Enter employee id:","Type here.."));
	int mgrId=Integer.parseInt(JOptionPane.showInputDialog("Enter manager id:","Type here.."));
	mgrService.assignEmployeeToManager(empId, mgrId);
	System.out.println("Employee has been assigned to manager successfully");
}

public static void getManagerById() throws GlobalException {
	
	int id=Integer.parseInt(JOptionPane.showInputDialog("Enter id to search :","Type here.."));
	ManagerDTO mgr=mgrService.getManagerById(id);
	System.out.println("Manager Name:"+mgr.getMgrName());
	System.out.println("Manager address:"+mgr.getMgrAddress());
	System.out.println("Manager salary:"+mgr.getSalary());
	System.out.println("Manager contact no. :"+mgr.getContact());
	System.out.println("Manager email:"+mgr.getEmail());
	System.out.println("Manager username:"+mgr.getUserName());
	System.out.println("Manager password:"+mgr.getPassword());
	System.out.println("Manager role:"+mgr.getRole());
}
public static void updateManagerById() throws GlobalException{
	int id=Integer.parseInt(JOptionPane.showInputDialog("Enter id to update:","Type here.."));
	Manager mgr=new Manager();
	String name=JOptionPane.showInputDialog("Enter name :"," Type here.. ");
	String add=JOptionPane.showInputDialog("Enter address :","Type here..");
	Double sal=Double.parseDouble(JOptionPane.showInputDialog("Enter salary :","Type here.."));
	String cont=JOptionPane.showInputDialog("Enter contact no. :","Type here..");
	String email=JOptionPane.showInputDialog("Enter email :","Type here..");
	String user=JOptionPane.showInputDialog("Enter user name:","Type here..");
	String pass=JOptionPane.showInputDialog("Enter password:","Type here..");
	
	mgr.setMgrName(name);
	mgr.setMgrAddress(add);
	mgr.setSalary(sal);
	mgr.setContact(cont);
	mgr.setEmail(email);
	mgr.setUserName(user);
	mgr.setPassword(pass);
	//mgr.setRole("manager");
	mgrService.updateManagerById(id, mgr);
	//mgrService.updateManagerById(Integer.parseInt(JOptionPane.showInputDialog("Enter id to update:","Type here..")), mgr);
	System.out.println("Manager details updated successfully");
}
public static void deleteManagerById() {
	int id=Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete","Type here.."));
	mgrService.deleteManagerById(id);
	JOptionPane.showMessageDialog(null, "Object is deleted");
}
public static void login() {
	mgrService.login(JOptionPane.showInputDialog("Enter username:","Type here.."),JOptionPane.showInputDialog("Enter password:","Type here.."));
	
}
public static void afterLoginManager() {
	System.out.println();
	System.out.println("(A) To fetch manager details using id\n(B) To update manager details\n(C) Assign employee to manager\n(D) Return to manager menu ");
	  String choice=JOptionPane.showInputDialog("Enter choice: "," Type here....");
      switch(choice) {
      case "A":
    	  getManagerById();
    	  break;
      case"B":
    	  updateManagerById();
    	  break;
      case "C":
    	  assignEmployeeToManager();
    	  break;
      case "D":
    	 return;
      }
}
}
