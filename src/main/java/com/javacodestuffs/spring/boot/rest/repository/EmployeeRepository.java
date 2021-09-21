package com.javacodestuffs.spring.boot.rest.repository;

import org.springframework.stereotype.Repository;

import com.javacodestuffs.spring.boot.rest.core.sqljpa.entity.AbstractJpaRepository;
//import com.javacodestuffs.spring.boot.rest.core.sqljpa.entity.AbstractJpaRepository;
import com.javacodestuffs.spring.boot.rest.entity.EmployeeEntity;
 
 
@Repository
public interface EmployeeRepository extends AbstractJpaRepository<EmployeeEntity,Long>  {

}
