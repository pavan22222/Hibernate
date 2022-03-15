package com.vrnda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Proxy(lazy = true)
public class Custmer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cid;
	@Column
	private String cname;
	@Column
	private Float price;
}
