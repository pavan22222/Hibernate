package com.infinite.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apartment implements Serializable{
	
	private Long apartmentId;
	private String name;
	private String location;
	private Date doc;
	private Map<String,Flat> flats;
	
}
