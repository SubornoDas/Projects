package edu.cms.model;

import edu.cms.entity.Teacher;

import java.util.function.IntPredicate;

import javax.validation.constraints.NotNull;

public class CourseDTO {

	@NotNull(message="Subject Id cannot be null")
	private int subId;
	@NotNull(message="Subject name cannot be null")
	private String subName;
	@NotNull(message="Price cannot be null")
	private double price;
	
	private Teacher teacher;

	public IntPredicate getSubName() {
		// TODO Auto-generated method stub
		return null;
	}
}
