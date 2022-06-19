package com.infinite.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Address {
	
	@Id
	@GenericGenerator(name = "address-generator", strategy  = "com.infinite.generators.AddressGenerator")
	@GeneratedValue(generator = "address-generator",strategy = GenerationType.SEQUENCE)
	@Column(name="addr_id",unique = true,updatable = false)
	private String addrId;
	@Column(length = 20)
	private String doorNo;
	@Column(length = 30)
	private String colonyName;
	@Column(length = 30)
	private String distrcit;
	@Column(length = 30)
	private String state;
}
