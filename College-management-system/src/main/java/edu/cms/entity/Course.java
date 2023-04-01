package edu.cms.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import  javax.persistence.ManyToOne;
import  javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Course {

	@Id
	private int subId;
	@Column(name="sub_name", length=50,nullable=false)
	private String subName;
	@Column(length=30,nullable=false)
	private double price ;
	
	@ManyToOne
	private Teacher teacher;
}
