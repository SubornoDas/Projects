package com.ems.daoimpl;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ems.DAO.AdminDAO;
import com.ems.config.HibernateUtil;
import com.ems.entity.Admin;
import com.ems.service.AdminService;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public void saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		try(Session session=HibernateUtil.getSession()){
			session.beginTransaction();
			session.save(admin);
			session.getTransaction().commit();
			session.clear();
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
			
		}
	}

	@Override
	public boolean login(String userName, String password) {
		try(Session session=HibernateUtil.getSession()){
		int id=Integer.parseInt(JOptionPane.showInputDialog("Enter id:","Type here.."));
		Admin admin=session.get(Admin.class, id);
		if(admin.getUserName().equals(userName)&& admin.getPassword().equals(password)&& admin.getRole().equals("admin"))
		{
			JOptionPane.showMessageDialog(null, "Log in successfull");
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "wrong Credentials");
		
		
		return false;
	}

}
}

	@Override
	public Admin getAdminById(int id) {
		try(Session session=HibernateUtil.getSession()){
			Admin admin=session.get(Admin.class, id);
			return admin;
		}
		
	}

	@Override
	public Admin updateAdminById(int id, Admin admin) {
		try(Session session=HibernateUtil.getSession()){
			Admin adm=session.get(Admin.class, id);
			adm.setAdminName(adm.getAdminName());
			adm.setAdminEmail(adm.getAdminEmail());
			
			adm.setUserName(adm.getUserName());
			adm.setPassword(adm.getPassword());
			
			session.beginTransaction();
			session.saveOrUpdate(adm);
			session.getTransaction().commit();
			return adm;
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
	public void deleteAdminById(int id) {
		try(Session session=HibernateUtil.getSession()){
			Admin admn=session.load(Admin.class, id);
			session.beginTransaction();
			int input=JOptionPane.showConfirmDialog(null, "Do you want to delete ?","Are you sure ?",JOptionPane.YES_NO_OPTION);
			
			if(input==0) {
				session.delete(admn);
				JOptionPane.showMessageDialog(null, "Object is deleted !!!");
			}
			else {
				JOptionPane.showMessageDialog(null, "User wants to retain it !!!");
			}
			session.getTransaction().commit();
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
	}
}
