package com.vrnda.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Proxy(lazy=true)

@NamedNativeQuery(name="INSERT_EMPLOYEE",query = "INSERT INTO EMPLOYEE(ID,NAME,AGE,SALARY) VALUES(PRODUCT_ID.NEXTVAL,?1,?2,?3)")
@NamedNativeQuery(name="DELETE_EMPLOYEE",query = "DELETE FROM EMPLOYEE WHERE ID=:ID")
//@NamedNativeQueries(value={@NamedNativeQuery(name="",query = "")})
public class Employee {
	@Id
	@Column
	@SequenceGenerator(name="seq",sequenceName = "PRODUCT_ID",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "seq",strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String name;
	@Column
	private String designation;
	@Column
	//@Transient
	private Integer age;
	@Version
	private Integer version;
	@Column
	private Float salary;
	@Column
	private LocalDate doj;
	@Column
	@CreationTimestamp
	private LocalDateTime creationDate;
	@Column
	@UpdateTimestamp
	private Date lastUpdationDate;
	
}
