package com.vrnda.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
	
	@Id
	@SequenceGenerator(name = "seq",sequenceName = "PRODUCT_ID",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "seq",strategy = GenerationType.AUTO)
	private Integer id;
	@Version
	private Integer version;
	@NonNull
	private String name;
	@NonNull
	private Integer age;
	@NonNull
	private Double salary;
	@NonNull
	private LocalDateTime doj;
	@CreationTimestamp
	private Date creationDate;
	@UpdateTimestamp
	private Date lastUpdationDate;
}
