package com.vrnda.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="EMPLOYEE")
@Proxy(lazy=true)
public class Employee implements Serializable{
	@Id
	@SequenceGenerator(name = "seq",sequenceName = "PRODUCT_ID",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "seq",strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String name;
	@Column
	private Integer age;
	@Column
	@Version
	private Integer version;
	@Column(length=30)
	private String designation;
	@Column
	private Float salary;
	@Column
	private LocalDateTime doj;
	@Column
	@CreationTimestamp
	private LocalDateTime creationDate;
	@Column
	@UpdateTimestamp
	private LocalDateTime lastUpdationDate;
	
}
