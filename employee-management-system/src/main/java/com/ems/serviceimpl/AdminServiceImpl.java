package com.ems.serviceimpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ems.DAO.AdminDAO;
import com.ems.daoimpl.AdminDAOImpl;
import com.ems.entity.Admin;
import com.ems.exception.GlobalException;
import com.ems.model.AdminDTO;
import com.ems.service.AdminService;

public class AdminServiceImpl implements AdminService{
	
	// logger used to keep tracks of records
	private static final Logger logger=LoggerFactory.getLogger(AdminServiceImpl.class);
	
	// accessing the data access layer(DAO) to call the methods
	AdminDAO adminDao=new AdminDAOImpl();
	
	// method to save details of an employee
	@Override
	public void saveAdmin(Admin admin) {
		adminDao.saveAdmin(admin);
		
	}

	// method to login admin
	@Override
	public boolean login(String userName, String password) {
	
		return adminDao.login(userName, password);
		
	}
	
	//method to get details of an employee using id
	@Override
	public AdminDTO getAdminById(int id) {
		Admin admin=adminDao.getAdminById(id);
		if(admin!=null) {
			logger.info("Admin with id"+id+" was retrieved at "+new Date());
			return new ModelMapper().map(admin, AdminDTO.class);
		}
		else
			logger.error("Admin with id"+id+" was not found");
			throw new GlobalException("Admin details not found !!!");
	}

	@Override
	public AdminDTO updateAdminById(int id, Admin admin) {
		Admin adm=adminDao.updateAdminById(id, admin);
		if(admin!=null) {
			return new ModelMapper().map(adm, AdminDTO.class);
		}
		else {
			throw new GlobalException("Admin with id"+id+" not found");
		}
	
	}

	@Override
	public void deleteAdminById(int id) {
		adminDao.deleteAdminById(id);
		
	}

}
