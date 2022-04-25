package com.infinite.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pant {
	
	private Long pantId;
	private String brand;
	//private Integer size;
	private String colour;

}
