package com.javacodestuffs.spring.boot.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
 

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
@Entity(name = "employee")
public class EmployeeEntity extends AbstractJpaEntity {
 
	private static final long serialVersionUID = 1L;
 
 
	@Column(name = "firstName", columnDefinition = "varchar(20)", nullable = false)
	private String firstName;

	@Column(name = "lastName", columnDefinition = "varchar(20)", nullable = false)
	private String lastName;

	@Column(name = "mobile", columnDefinition = "varchar(20)", nullable = false)
	private String mobile;

	@Column(name = "email", columnDefinition = "varchar(20)", nullable = false)
	private String email;

	@Column(columnDefinition = "TEXT", name = "address")
	private String address;
	
	@Column(columnDefinition = "TEXT", name = "department")
	private String department;

}
