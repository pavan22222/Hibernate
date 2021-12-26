package com.vrnda.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Programmer")
public class Programmer {
	@EmbeddedId
	private ProgProjIDDetails id;
	@Column(length=30)
	private String name;
	@Column(length=30)
	private String projName;
	private Double salary;
	private LocalDate doj;
	private LocalDateTime dom;
	private LocalTime dob;
}
