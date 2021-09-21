package com.javacodestuffs.spring.boot.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacodestuffs.spring.boot.rest.dto.EmployeeDto;
import com.javacodestuffs.spring.boot.rest.dto.ResponseDto;
import com.javacodestuffs.spring.boot.rest.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/employee")
public class EmployeeController {
	@Autowired

	private EmployeeService employeeService;

	@PostMapping()
	public ResponseDto<EmployeeDto> createAdditionalVar(@RequestBody @Validated EmployeeDto EmployeeDto) {
		log.info(" EmployeeDto  id: {} ", EmployeeDto);

		return ResponseDto.success("Employee added successfully", employeeService.addEmployee(EmployeeDto));
	}

	@PutMapping()
	public ResponseDto<EmployeeDto> updateAdditionalVar(@RequestBody @Validated EmployeeDto EmployeeDto) {
		log.info(" EmployeeDto  id: {} ", EmployeeDto);

		return ResponseDto.success("Employee updated successfully", employeeService.updateEmployee(EmployeeDto));
	}

	@GetMapping("/uuid/{uuid}")
	public ResponseDto<EmployeeDto> getEmployeeByUUID(@PathVariable String uuid) {
		log.info(" getEmployeeByUUID id: {} ", uuid);
		return ResponseDto.success(" getEmployeeByUUID ", employeeService.getEmployeeByUUID(uuid));
	}

	@GetMapping("/{id}")
	public ResponseDto<EmployeeDto> getEmployeeById(@PathVariable Long id) {
		log.info(" getEmployeeById id: {} ", id);
		return ResponseDto.success(" getEmployeeById ", employeeService.getEmployeeById(id));
	}

	@DeleteMapping("/{id}")
	public ResponseDto<EmployeeDto> deleteEmployeeById(@PathVariable Long id) {
		log.info(" deleteEmployeeById id: {} ", id);
		employeeService.deleteEmployee(id);
		return ResponseDto.success("Employee deleted successfully");
	}

}