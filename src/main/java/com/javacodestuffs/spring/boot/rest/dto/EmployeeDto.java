package com.javacodestuffs.spring.boot.rest.dto;

import java.util.Date;

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
public class EmployeeDto {
	private Long id;

	private String employeeUuid;

	private String firstName;

	private String lastName;

	private String mobile;

	private String email;

	private String address;

	private String department;

	private Date createdAt;
  
	private Date updatedAt;
	
	private boolean status;
}
