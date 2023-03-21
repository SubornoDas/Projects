package com.ems.model;

import java.util.List;

import javax.persistence.OneToMany;

import com.ems.entity.Employee;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ManagerDTO extends UserDTO {

	private String mgrName;
	private String mgrAddress;
	private double salary;
	private String contact;
	private String email;
	
}
