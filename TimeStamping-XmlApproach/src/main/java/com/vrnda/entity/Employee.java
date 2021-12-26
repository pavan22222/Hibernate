package com.vrnda.entity;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Employee {
	
	private Integer id;
	@NonNull
	private String name;
	@NonNull
	private Integer age;
	@NonNull
	private Double salary;
	@NonNull
	private LocalDateTime doj;
	@NonNull
	private Date creationDate;
	private Date lastUpdationDate;
}
