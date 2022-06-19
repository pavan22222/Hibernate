package com.infinite.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
@Entity
public class Student {
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "SID", initialValue = 1, allocationSize = 100)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(length = 20)
	private String name;
	private Integer age;
	@OneToMany(orphanRemoval = true,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id",name="st_id")
	private List<Address> addresses;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "dept_id")
	private Department department;
	@Column(length = 20,name = "dept_id",updatable = false,insertable = false)
	private String deptId;

}
