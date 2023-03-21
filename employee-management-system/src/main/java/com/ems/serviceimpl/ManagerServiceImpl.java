package com.ems.serviceimpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ems.DAO.ManagerDAO;
import com.ems.daoimpl.ManagerDAOImpl;
import com.ems.entity.Manager;
import com.ems.exception.GlobalException;
import com.ems.model.ManagerDTO;
import com.ems.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
	
	private static final Logger logger=LoggerFactory.getLogger(ManagerServiceImpl.class);
	
	ManagerDAO managerDAO=new ManagerDAOImpl();
	
	
	@Override
	public void saveManager(Manager manager) {
	logger.info("New manager details added successfully !!");
	
		managerDAO.saveManager(manager);
		
	}
	@Override
	public void assignEmployeeToManager(int employeeId, int managerId) {
	managerDAO.assignEmployeeToManager(employeeId, managerId);
	
		
	}
	@Override
	public ManagerDTO getManagerById(int id) {
		Manager manager=managerDAO.getManagerById(id);
		if(manager!=null) {
			logger.info("Manager with id"+id+" was retrieved at"+new Date());
			return new ModelMapper().map(manager, ManagerDTO.class);
		}
		else {
			logger.error("Manager with id"+id+" was not found");
			
			throw new GlobalException("Manager details not found");
			
			}
		
	}
	@Override
	public ManagerDTO updateManagerById(int id, Manager manager) {
		Manager mgr=managerDAO.updateManagerById(id, manager);
		if(mgr!=null) {
			return new ModelMapper().map(mgr, ManagerDTO.class);
			}
		else {
			throw new GlobalException("Manager with id"+id+" not found");
			
		}
	}
	@Override
	public ManagerDTO deleteManagerById(int id) {
		managerDAO.deleteManagerById(id);
		return null;
	}
	@Override
	public boolean login(String userName, String password) {
		
		
		return managerDAO.login(userName, password);
	}

}
