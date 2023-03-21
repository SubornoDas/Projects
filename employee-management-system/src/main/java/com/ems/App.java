package com.ems;

import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ems.entity.Employee;
import com.ems.service.AdminService;
import com.ems.service.EmployeeService;
import com.ems.service.ManagerService;
import com.ems.serviceimpl.AdminServiceImpl;
import com.ems.serviceimpl.EmployeeServiceImpl;
import com.ems.serviceimpl.ManagerServiceImpl;

public class App 
{
	static AdminService adminService=new AdminServiceImpl();
	static EmployeeService empService=new EmployeeServiceImpl();
	static ManagerService mgrService=new ManagerServiceImpl();
	static Scanner sc=new Scanner(System.in);
	
    public static void main( String[] args )
    {
    	mainMenu();
    }
    public static void mainMenu() {
    	int ch;
    	do {
        System.out.println("|=============== Welcome to Employee Management System ===============| ");
        System.out.println();
        System.out.println("1) Admin\n2) Employee\n3) Manager\n4) Exit");
    //    ch=sc.nextInt();
        ch=Integer.parseInt(JOptionPane.showInputDialog("Enter choice:","Type here"));
        switch(ch)
        {
        case 1: mainadmin();
        	break;
      
        case 2:
        	mainUser();
        case 3:
        	mainManager();
        	break;
        case 4:
        	System.exit(0);
        	default:
        		System.out.println("Wrong Input !!!");
        }
    	}while(ch!=4);
    }
// menu for employee entity
	private static void mainUser() {
		// TODO Auto-generated method stub
		System.out.println();
		do {
		//EmployeeService empService=new EmployeeServiceImpl();
		System.out.println("|=============== EMPLOYEE ===============|");
		System.out.println("(A) Login\n(B) Exit");
		//char choice = sc.next().charAt(0);
		String choice=JOptionPane.showInputDialog("Enter choice: ","Type here....");
		switch(choice)
		{
		case "A":
			boolean status=empService.login(JOptionPane.showInputDialog("Enter username:","Type here.."),JOptionPane.showInputDialog("Enter password:","Type here.."));
			
			if (status==true) {
				EmployeeCRUD.afterLoginEmployee();
			}
			else {
				JOptionPane.showMessageDialog(null, "Wrong credentials");
		}
		break;
		case "B":
			mainMenu();
			break;
		}
		}while(true);
	}
		
	//		Employee emp= new Employee();
//		
//			sc.nextLine();
//			System.out.println("Enter name : ");
//			String name=sc.nextLine();
//			System.out.println("Enter address : ");
//			String add=sc.nextLine();
//			System.out.println("Enter salary : ");
//			double sal=sc.nextDouble();
//			System.out.println("Enter contact no : ");
//			String cont=sc.next();
//			sc.nextLine();
//			System.out.println("Enter email : ");
//			String email=sc.nextLine();
//			System.out.println("Enter designation : ");
//			String des=sc.nextLine();
//			System.out.println("Enter DOJ : ");
//			LocalDate date=LocalDate.parse(sc.next());  //yyyy-mm-dd
//			System.out.println("Enter username : ");
//			String user=sc.nextLine();
//			sc.nextLine();
//			System.out.println("Enter password : ");
//			String pass=sc.nextLine();			 
//			
//			
//			emp.setEmpName(name);
//			emp.setEmpAddress(add);
//			emp.setSalary(sal);
//			emp.setContact(cont);
//			emp.setEmail(email);
//			emp.setDesignation(des);
//			emp.setDOJ(date);
//			emp.setUserName(user);
//			emp.setPassword(pass);
//			emp.setRole("employee");
////			
//			empService.saveEmployee(emp);
//			System.out.println("Employee details saved !!!");
//			break;
//		}

	public static void mainadmin() {
		System.out.println();
		do {
			
		System.out.println("|============== ADMIN ================|");
		System.out.println("A) Login\nB) Exit");
		String choice=JOptionPane.showInputDialog("Enter choice :","Type here..");
		switch(choice) {
		case "A":
			boolean status=adminService.login(JOptionPane.showInputDialog("Enter user_name:","Type here.."),JOptionPane.showInputDialog("Enter password:","Type here.."));
			if(status==true) {
				
				AdminCRUD.afterLoginAdmin();
			}
			else {
				
				JOptionPane.showMessageDialog(null, "Wrong Credentials");
			}
			//AdminCRUD.login();
			break;
		case "B":
				App.mainMenu();
				break;
		
			
		}
		}while(true);
	}
	private static void mainManager() {
		System.out.println();
		ManagerService mgrService=new ManagerServiceImpl();
		do {
		System.out.println("|=================== MANAGER ===================|");
		System.out.println("(A) Login\n(B) Exit");
						
		String choice=JOptionPane.showInputDialog("Enter choice:","Type here..");
		switch(choice) {
		case "A":
			boolean status=mgrService.login(JOptionPane.showInputDialog("Enter user name:", "Type here"),
		    		JOptionPane.showInputDialog("Enter password:","Type here.."));
		    		
		    		if(status==true)
		    		{
		    		  ManagerCRUD.afterLoginManager();
		    		}
		    		else 
		    		{
		    		  JOptionPane.showMessageDialog(null, "Wrong credentials");
		    		}
		    		break;
		    	case "B":
		    		mainMenu();
		    		break;	
		    	}
			}while(true);
		      	
		    	
		    }
}
		
	
	

