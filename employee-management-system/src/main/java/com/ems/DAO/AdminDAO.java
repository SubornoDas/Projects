package com.ems.DAO;

import com.ems.entity.Admin;

public interface AdminDAO {
	
void saveAdmin(Admin admin);
boolean login(String userName,String password);
Admin getAdminById(int id);
Admin updateAdminById(int id,Admin admin);
void deleteAdminById(int id);
}
