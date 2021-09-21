package com.javacodestuffs.spring.boot.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiErrorDto {

	private String errorCode;
	private String message;

	public ApiErrorDto(String errorCode, String message) {
	        super();
	        this.errorCode = errorCode;
	        this.message = message;
	}	    }