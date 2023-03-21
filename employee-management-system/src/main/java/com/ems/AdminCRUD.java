package com.ems;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import com.ems.entity.Admin;
import com.ems.exception.GlobalException;
import com.ems.model.AdminDTO;
import com.ems.service.AdminService;
import com.ems.serviceimpl.AdminServiceImpl;

	public class AdminCRUD {
		static AdminService adminService=new AdminServiceImpl();
// To save admin details
	public static void saveAdmin() {
		Admin admin=new Admin();

		String name=JOptionPane.showInputDialog("Enter name:","Type here..");
		String email=JOptionPane.showInputDialog("Enter email:","Type here..");
		String user=JOptionPane.showInputDialog("Enter user-name:","Type here..");
		String pass=JOptionPane.showInputDialog("Enter password:","Type here..");
		
		admin.setAdminName(name);
		admin.setAdminEmail(email);
		admin.setUserName(user);
		admin.setPassword(pass);
		admin.setRole("admin");
		
		adminService.saveAdmin(admin);
		System.out.println("New admin details has been added");
	}

// To fetch Admin details using id
	public static void getAdminById() throws GlobalException {
		
		int id1=Integer.parseInt(JOptionPane.showInputDialog("Enter id to search:","Type here.."));
		AdminDTO admin=adminService.getAdminById(id1);
		System.out.println("Admin Name:"+admin.getAdminName());
		System.out.println("Admin email:"+admin.getAdminEmail());
	}
	
	// To update Admin details using id
	public static void updateAdminById() throws GlobalException{
		
		Admin adm=new Admin();
		adminService.updateAdminById(Integer.parseInt(JOptionPane.showInputDialog("Enter id to update","Type here..")), adm);
		String name=JOptionPane.showInputDialog("Enter name:","Type here..");
		String email=JOptionPane.showInputDialog("Enter email:","Type here..");
		String user=JOptionPane.showInputDialog("Enter user-name:","Type here..");
		String pass=JOptionPane.showInputDialog("Enter password:","Type here..");
		
		adm.setAdminName(name);
		adm.setAdminEmail(email);
		adm.setUserName(user);
		adm.setPassword(pass);
		adm.setRole("admin");
		
		System.out.println("Admin details updated successfully !!!");
	}
	
	// To delete admin details using id
	public static void deleteAdminById() {
		
		int id=Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete: ", "Type here.."));
		adminService.deleteAdminById(id);
	}
	
	// To login as admin
	public static void login() {
			
		//String user=JOptionPane.showInputDialog("Enter user-name:","Type here..");
		//String pass=JOptionPane.showInputDialog("Enter password:","Type here..");
		adminService.login(JOptionPane.showInputDialog("Enter user_name:","Type here.."), JOptionPane.showInputDialog("Enter password:","Type here.."));
	
}
	
	public static void afterLoginAdmin() {
		System.out.println();
		System.out.println("(A)Save new admin\n(B)To fetch admin details using id\n"
				+ "(C) To update admin details using id\n(D) To delete admin details");
		
		System.out.println();
		
		System.out.println("(E) Save new employee\n"
				+ "(F) To fetch employee details using ID\n"
				+ "(G) To fetch employee details using email\n(H) To update employee details using id\n(I) To delete an employee details");
		
		System.out.println();
		
		System.out.println("(J)Save new Department\n(K)To fetch department details using id\n"
				+"(L) To update department details using id\n(M) To delete department details " 
				+"(N)Assign employee to department\n(O)Assign manager to department");
		
		System.out.println();
		
		System.out.println("P)Save new Manager\n(Q)To fetch Manager details using Id\n(R)To"
		    			+ "Update manager details\n(S)To Delete manager details\n(T)Assign employee to manager\n(U) Return to main admin");
		
		String choice=JOptionPane.showInputDialog("Enter choice:","Type here...");
		switch(choice)
		{
	
		case "A":
			AdminCRUD.saveAdmin();
			break;
	case "B":
			AdminCRUD.getAdminById();
			break;
	case "C":
			AdminCRUD.updateAdminById();
			break;
	case "D":
			AdminCRUD.deleteAdminById();
			break;	
		
	case "E":
			EmployeeCRUD.saveEmployee();
			break;
	case "F":
			EmployeeCRUD.getEmployeeById();
			break;
	case "G":
		EmployeeCRUD.getEmployeeByEmail();
		break;
	case "H":
			EmployeeCRUD.updateEmployee();
			break;
	case "I":
			EmployeeCRUD.deleteEmployee();
			break;	
	case "J":
			DepartmentCRUD.addDepartment();
			break;
	case "K":
			DepartmentCRUD.getDepartment();
			break;
	case "L":
			DepartmentCRUD.updateDepartmentUsingId();
			break;
	case "M":
			DepartmentCRUD.deleteDepartmentUsingId();
			break;	
	case "N":
		DepartmentCRUD.assignEmployeeToDepartment();
		break;
	case "O":
		DepartmentCRUD.assignMgrToDept();
		break;
	case "P":
			ManagerCRUD.saveManager();
			break;
	case "Q":
			ManagerCRUD.getManagerById();
			break;
	case "R":
			ManagerCRUD.updateManagerById();
			break;
	case "S":
			ManagerCRUD.deleteManagerById();
			break;
	
	case "T":
			ManagerCRUD.assignEmployeeToManager();
			break;
	
	case "U":
			App.mainadmin();
			break;
	}
}
}
