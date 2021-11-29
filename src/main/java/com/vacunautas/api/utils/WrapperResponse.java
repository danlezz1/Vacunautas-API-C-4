package com.vacunautas.api.utils;

//Clase para Estandarizar las respuestas del servidor

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WrapperResponse<T> {
	
	private boolean ok;
	private String message;
	private T body;
	
	public ResponseEntity<WrapperResponse<T>> createResponse(HttpStatus status) {
		return new ResponseEntity<>(this, status);
	}
	
}
