package com.ems.daoimpl;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ems.DAO.EmployeeDAO;
import com.ems.config.HibernateUtil;
import com.ems.entity.Employee;
import com.ems.model.EmployeeDTO;

public class EmployeeDAOImpl implements EmployeeDAO {

	// this method gets the session to save the new employee details
	
	public void saveEmployee(Employee employee) {
		try(Session session=HibernateUtil.getSession()){
			session.beginTransaction();
			// add all the new employee details
			session.save(employee);
			// java object saved to the database
			session.getTransaction().commit();
			
			// clear the session
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
	public Employee getEmployeeUsingId(int id) {
		try(Session session=HibernateUtil.getSession()){
		Employee employee=session.get(Employee.class, id);
		return employee;
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
	public Employee updateEmployee(int id, Employee empl) {
		
		try(Session session=HibernateUtil.getSession())
		{
			Employee emp=session.get(Employee.class, id);
			// updating existing details with the new one
			emp.setEmpName(empl.getEmpName());
			emp.setEmpAddress(empl.getEmpAddress());
			emp.setSalary(empl.getSalary());
			emp.setContact(empl.getContact());
			emp.setEmail(empl.getEmail());
			emp.setDesignation(empl.getDesignation());
			emp.setDOJ(empl.getDOJ());
			emp.setUserName(empl.getUserName());
			emp.setPassword(empl.getPassword());
			emp.setManager(emp.getDept().getMgr());
			session.beginTransaction();
			session.saveOrUpdate(emp);
			session.getTransaction().commit();
			
			return emp;  //returning employee entity
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
	public void deleteEmployeeById(int id) {
		try(Session session=HibernateUtil.getSession()){
			Employee employee=session.load(Employee.class, id);
			session.beginTransaction();
			int input=JOptionPane.showConfirmDialog(null, "Do you want to delete ?","Are you sure ?",JOptionPane.YES_NO_OPTION);
			if(input==0) {
				session.delete(employee);
				//session.evict(employee);
			
			}
			else {
				JOptionPane.showMessageDialog(null, "uSER WANTS TO RETAIN IT !");
					}
			session.getTransaction().commit();
		}
			catch(HibernateException e) {
				System.out.println(e.getMessage());
			}
		}

	@Override
	public EmployeeDTO getEmployeeByEmail(String email) {
		try(Session session=HibernateUtil.getSession()){
			String query="from Employee e where e.email:a";
			Query q=session.createQuery(query);
			q.setParameter("a", email);
			EmployeeDTO emp=(EmployeeDTO) q.uniqueResult();
			return emp;
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
			int id=Integer.parseInt(JOptionPane.showInputDialog("Enter employee id:","Type here.."));
			Employee emp=session.get(Employee.class, id);
			if(emp.getUserName().equalsIgnoreCase(userName)&& emp.getPassword().equalsIgnoreCase(password)&&emp.getRole().equalsIgnoreCase("Employee")) {
				JOptionPane.showMessageDialog(null, "Successfully logged in !!!");
				return true;
				
			}else {
				JOptionPane.showMessageDialog(null, "Wrong credentials !!!");
				return false;
			}
		
		}
	
	}
		
	}


	
	

