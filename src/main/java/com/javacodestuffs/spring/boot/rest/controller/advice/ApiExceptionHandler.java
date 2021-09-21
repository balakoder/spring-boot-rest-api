package com.javacodestuffs.spring.boot.rest.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.javacodestuffs.spring.boot.rest.dto.ApiErrorDto;
import com.javacodestuffs.spring.boot.rest.exception.NoRecordException;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(NoRecordException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiErrorDto handleValidationError(NoRecordException ex) {
 
		return new ApiErrorDto("NOT_FOUND", "No Record Found!");
	}
}