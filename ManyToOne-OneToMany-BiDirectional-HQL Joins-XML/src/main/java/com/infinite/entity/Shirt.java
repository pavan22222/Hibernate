package com.infinite.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shirt {
	
	private BigDecimal shirtId;
	private BigDecimal pantId;
	private String brand;
	private String colour;
	private Pant pant;
	
}
