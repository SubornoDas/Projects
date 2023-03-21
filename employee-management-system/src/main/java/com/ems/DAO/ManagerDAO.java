package com.ems.DAO;

import com.ems.entity.Manager;
import com.ems.model.ManagerDTO;

public interface ManagerDAO {
void saveManager(Manager manager);
Manager getManagerById(int id);
Manager updateManagerById(int id,Manager manager);
Manager deleteManagerById(int id);
void assignEmployeeToManager(int employeeId,int managerId);
boolean login(String userName,String password);
}
