package com.infinite.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pant {
	
	private Long pantId;
	private String brand;
	private String colour;
	private List<Shirt> shirts;

}
