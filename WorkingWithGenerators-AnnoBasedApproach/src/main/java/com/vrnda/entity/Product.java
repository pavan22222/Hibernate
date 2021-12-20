package com.vrnda.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="PRODUCTS")
@Data
@RequiredArgsConstructor
public class Product {
	@Id
	/*
	 * @GenericGenerator(name = "inc",strategy = "increment")
	 * 
	 * @GeneratedValue(generator = "inc")
	 */
	
	
//	  @GenericGenerator(name = "seq",strategy =
//	  "org.hibernate.id.SequenceGenerator",parameters = @Parameter(value =
//	  "PRODUCT_ID",name = "sequence"))
//	  
//	  @GeneratedValue(generator = "seq")
	 
	//Working with JPA Given Annotations
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@SequenceGenerator(name = "seq",sequenceName = "PRODUCT_ID_SEQ",initialValue = 200,allocationSize = 1)
//	@SequenceGenerator(name = "seq",sequenceName = "PRODUCT_ID",initialValue = 200,allocationSize = 1)
//	@GeneratedValue(generator = "seq",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq",sequenceName = "PRODUCT_ID",initialValue = 200,allocationSize = 1)
	@GeneratedValue(generator = "seq",strategy = GenerationType.AUTO)
	private Integer pid;
	@NonNull
	@Column(length = 30,nullable = false)
	private String pname;
	@NonNull
	@Column(length = 30,nullable = false)
	private Double price;
	@NonNull
	@Column(length = 30,nullable = true)
	private LocalDateTime dom;
	@NonNull
	private LocalDateTime doe;
}
