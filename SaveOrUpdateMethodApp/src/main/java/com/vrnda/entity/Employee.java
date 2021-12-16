package com.vrnda.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Employee implements Serializable {
	private Integer id; 
	private String name; 
	private Integer age; 
	private Float salary; 
	private Date doj;
}
