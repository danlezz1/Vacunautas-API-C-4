package com.vacunautas.api.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vacunautas.api.exceptions.GeneralServiceException;
import com.vacunautas.api.exceptions.NotDataFoundException;
import com.vacunautas.api.exceptions.ValidateServiceException;
import com.vacunautas.api.utils.WrapperResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ErrorHandlerConfig extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> all(Exception e, WebRequest request){
		log.error(e.getMessage(), e);
		WrapperResponse<?> response = new WrapperResponse<>(false, "Internal Server Error", null);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(GeneralServiceException.class)
	public ResponseEntity<?> GeneralServiceException(GeneralServiceException e, WebRequest request){
		log.error(e.getMessage(), e);
		WrapperResponse<?> response = new WrapperResponse<>(false, "Internal Server Error", null);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ValidateServiceException.class)
	public ResponseEntity<?> ValidateServiceException(ValidateServiceException e, WebRequest request){
		log.info(e.getMessage(), e);
		WrapperResponse<?> response = new WrapperResponse<>(false, e.getMessage(), null);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotDataFoundException.class)
	public ResponseEntity<?> NotDataFoundException(NotDataFoundException e, WebRequest request){
		log.info(e.getMessage(), e);
		WrapperResponse<?> response = new WrapperResponse<>(false, e.getMessage(), null);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
