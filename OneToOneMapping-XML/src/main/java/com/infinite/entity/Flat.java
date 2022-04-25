package com.infinite.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flat implements Serializable{
	
	private Integer flatId;
	private Integer version;
	private String flatIndex;
	private String flatNumer;
	private Double price;
	
}
