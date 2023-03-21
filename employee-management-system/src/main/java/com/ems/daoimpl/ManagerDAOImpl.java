package com.ems.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ems.DAO.ManagerDAO;
import com.ems.config.HibernateUtil;
import com.ems.entity.Employee;
import com.ems.entity.Manager;
import com.ems.model.ManagerDTO;

public class ManagerDAOImpl implements ManagerDAO {

	@Override
	public void saveManager(Manager manager) {
		try(Session session=HibernateUtil.getSession()){
			session.beginTransaction();
			session.save(manager);
			session.getTransaction().commit();
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
	public void assignEmployeeToManager(int employeeId, int managerId) {
		
		try(Session session=HibernateUtil.getSession())
		{
			Employee empl= session.get(Employee.class, employeeId);
			Manager mgr=session.get(Manager.class, managerId);
			
			List<Employee> employees=new ArrayList<>();
			employees.add(empl);
			
			mgr.setEmployee(employees);
			empl.setManager(mgr);
			mgr.setEmployee(mgr.getEmployee());
			session.beginTransaction();
			session.saveOrUpdate(mgr);
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
	public Manager getManagerById(int id) {
		
		try(Session session=HibernateUtil.getSession()){
			Manager manager=session.get(Manager.class, id);
			return manager;
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
	public Manager updateManagerById(int id,Manager mgr1) {
		
		try(Session session=HibernateUtil.getSession()){
			Manager mgr=session.get(Manager.class, id);
			mgr.setMgrName(mgr1.getMgrName());
			mgr.setMgrAddress(mgr1.getMgrAddress());
			mgr.setSalary(mgr1.getSalary());
			mgr.setContact(mgr1.getContact());
			mgr.setEmail(mgr1.getEmail());
			mgr.setUserName(mgr1.getUserName());
			mgr.setPassword(mgr1.getPassword());
			session.beginTransaction();
			session.saveOrUpdate(mgr);
			session.getTransaction().commit();
			
			return mgr;  // returning manager entity
			
			
			
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
	public Manager deleteManagerById(int id) {
		try(Session session=HibernateUtil.getSession()){
			Manager mgr=session.get(Manager.class, id);
			session.beginTransaction();
			int input=JOptionPane.showConfirmDialog(null, "Do you want to delete","Are you sure ?",JOptionPane.YES_NO_OPTION);
			if(input==0) {
			session.delete(mgr);
			
		}
			else
		{
			JOptionPane.showMessageDialog(null, "User wants to retain it");
		}
			session.getTransaction().commit();
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
	public boolean login(String userName, String password) {
	
		try(Session session=HibernateUtil.getSession()){
			int id=Integer.parseInt(JOptionPane.showInputDialog("Enter manager Id: ", "Type here.."));
	    	Manager mgr=session.get(Manager.class, id);
	    	if(mgr.getUserName().equalsIgnoreCase(userName) && mgr.getPassword().equalsIgnoreCase(password) && mgr.getRole().equalsIgnoreCase("Manager")) 
	    	{
	    		JOptionPane.showMessageDialog(null, "Successfully logged in!!");
	    		return true;
	    	}
	    	else 
	    	{
	    		JOptionPane.showMessageDialog(null, "Wrong credentials!!");
	    		return false;
	    	}
	    
	    }
		
		
	}
}
