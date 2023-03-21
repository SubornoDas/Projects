package com.ems.service;

import com.ems.entity.Manager;
import com.ems.model.ManagerDTO;

public interface ManagerService {
void saveManager(Manager manager);
ManagerDTO getManagerById(int id);
ManagerDTO updateManagerById(int id,Manager manager);
ManagerDTO deleteManagerById(int id);
void assignEmployeeToManager(int employeeId,int managerId);
boolean login(String userName,String password);
}
