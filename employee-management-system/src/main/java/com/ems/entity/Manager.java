package com.ems.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Manager extends User{
	@Column(length=30,nullable=false)
private String mgrName;
	
	@Column(length=20,nullable=false)
private String mgrAddress;
	
	@Column(length=20,nullable=false)
private double salary;
	
	@Column(length=10,nullable=false)
private String contact;

	@Column(length=50,nullable=false,unique=true)
	private String email;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Employee> employee;
}
