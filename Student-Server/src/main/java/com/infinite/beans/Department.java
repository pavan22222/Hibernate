package com.infinite.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class Department {
	
	@Id
	@GenericGenerator(name="department_generator",strategy  = "com.infinite.generators.DepartmentGenerator")
	@GeneratedValue(generator = "department_generator",strategy = GenerationType.SEQUENCE)
	@Column(name="dept_id",length = 30)
	private String deptId;
	@Column(name="dept_name",length = 30)
	private String deptName;
	@Column(length = 30)
	private String comments;
	
}
