package com.vrnda.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class ProgProjIDDetails implements Serializable{
	private Integer progId;
	private Integer projId;
}
