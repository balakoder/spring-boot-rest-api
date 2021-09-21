package com.javacodestuffs.spring.boot.rest.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javacodestuffs.spring.boot.rest.dto.EmployeeDto;
import com.javacodestuffs.spring.boot.rest.entity.EmployeeEntity;

import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

@UtilityClass
@Log4j2
public class EmployeeAdapter {
	ObjectMapper mapper = new ObjectMapper();

	public static EmployeeDto getEmployeeDto(EmployeeEntity employeeEntity) {

		log.info("EmployeeEntity Email {}", employeeEntity.getEmail());
		return EmployeeDto.builder().address(employeeEntity.getAddress()).email(employeeEntity.getEmail())
				.id(employeeEntity.getId()).department(employeeEntity.getDepartment())
				.employeeUuid(employeeEntity.getUuid()).firstName(employeeEntity.getFirstName())
				.lastName(employeeEntity.getLastName()).mobile(employeeEntity.getMobile())
				.status(employeeEntity.isStatus()).createdAt(employeeEntity.getCreatedAt())
				.updatedAt(employeeEntity.getUpdatedAt()).build();

	}

	public static List<EmployeeDto> getListingEmployeeDtos(List<EmployeeEntity> employeeEntity) {

		if (CollectionUtils.isEmpty(employeeEntity)) {
			return new ArrayList<>();
		}
		return employeeEntity.stream().map(EmployeeAdapter::getEmployeeDto).collect(Collectors.toList());

	}

}