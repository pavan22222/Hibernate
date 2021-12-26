package com.vrnda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Programmer {
	private ProgProjIDDetails id;
	private String name;
	private String projName;
	private Double salary;
}
