package com.vrnda.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//@Entity
//@Table(name="PRODUCT")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Product {
	//@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer pid;
	@NonNull
	//@Column(length = 30,nullable = false)
	private String pname;
	@NonNull
	//@Column(length = 30,nullable = false)
	private Double price;
	@NonNull
	//@Column(length = 30,nullable = true)
	private LocalDateTime dom;
	@NonNull
	private LocalDateTime doe;
	private Integer version;
}
