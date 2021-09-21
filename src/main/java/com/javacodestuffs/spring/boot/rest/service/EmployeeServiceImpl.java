package com.javacodestuffs.spring.boot.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacodestuffs.spring.boot.rest.adapter.EmployeeAdapter;
import com.javacodestuffs.spring.boot.rest.db.service.EmployeeDbService;
import com.javacodestuffs.spring.boot.rest.dto.EmployeeDto;
import com.javacodestuffs.spring.boot.rest.entity.EmployeeEntity;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDbService employeeDbService;

	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {

		EmployeeEntity employeeEntity = EmployeeEntity.builder().address(employeeDto.getAddress())
				.department(employeeDto.getDepartment()).email(employeeDto.getEmail())
				.firstName(employeeDto.getFirstName()).id(employeeDto.getId()).lastName(employeeDto.getLastName())
				.mobile(employeeDto.getMobile()).build();
		EmployeeEntity employeeEntitySaved = employeeDbService.saveEmployee(employeeEntity);
		log.info("employee saved in database {} ", employeeEntitySaved);

		return EmployeeAdapter.getEmployeeDto(employeeEntitySaved);
	}

	@Override
	public EmployeeDto getEmployeeByUUID(String uuid) {

		EmployeeEntity employeeEntity = employeeDbService.findEmployeeByUUID(uuid);
		log.info("Get employee by uuid from database {} ", employeeEntity);
		return EmployeeAdapter.getEmployeeDto(employeeEntity);
	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {
		EmployeeEntity employeeEntity = employeeDbService.getEmployeeById(id);
		log.info("Get EmployeeById from database {} ", employeeEntity);
		return EmployeeAdapter.getEmployeeDto(employeeEntity);
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeDbService.deleteEmployee(id);

	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto) {

		EmployeeEntity employeeEntity = employeeDbService.updateEmployee(employeeDto);

		return EmployeeAdapter.getEmployeeDto(employeeEntity);
	}

}
