package com.vrnda.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProgProjIDDetails implements Serializable{
	private Integer progId;
	private Integer projId;
}
