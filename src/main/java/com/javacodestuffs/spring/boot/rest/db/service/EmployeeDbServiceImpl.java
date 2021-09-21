package com.javacodestuffs.spring.boot.rest.db.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacodestuffs.spring.boot.rest.dto.EmployeeDto;
import com.javacodestuffs.spring.boot.rest.entity.EmployeeEntity;
import com.javacodestuffs.spring.boot.rest.exception.NoRecordException;
import com.javacodestuffs.spring.boot.rest.repository.EmployeeRepository;

@Service
public class EmployeeDbServiceImpl implements EmployeeDbService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public EmployeeEntity saveEmployee(EmployeeEntity entity) {
		EmployeeEntity employeeEntity = employeeRepository.saveAndFlush(entity);
		return employeeEntity;
	}

	@Override
	public EmployeeEntity findEmployeeByUUID(String uuid) {
		EmployeeEntity employeeEntity = employeeRepository.findFirstByUuid(uuid);
		return employeeEntity;
	}

	@Override
	public EmployeeEntity getEmployeeById(Long id) {
		Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);

		if (employeeEntity.isPresent()) {
			return employeeEntity.get();
		} else {
			throw new NoRecordException("Employee not Found!");
		}

	}

	@Override
	public void deleteEmployee(Long id) {
		Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
		if (employeeEntity.isPresent()) {
			employeeRepository.delete(employeeEntity.get());
		} else {
			throw new NoRecordException("Employee not Found!");
		}

	}

	@Override
	public EmployeeEntity updateEmployee(EmployeeDto employeeDto) {
		Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeDto.getId());
		EmployeeEntity employeeEntityUpdate = employeeEntity.get();
		if (employeeDto.getDepartment() != null) {
			employeeEntityUpdate.setDepartment(employeeDto.getDepartment());
		}
		if (employeeDto.getFirstName() != null) {
			employeeEntityUpdate.setFirstName(employeeDto.getFirstName());

		}

		if (employeeDto.getLastName() != null) {
			employeeEntityUpdate.setLastName(employeeDto.getLastName());
		}

		if (employeeDto.getMobile() != null) {
			employeeEntityUpdate.setMobile(employeeDto.getMobile());
		}

		return employeeRepository.saveAndFlush(employeeEntityUpdate);

	}

}
