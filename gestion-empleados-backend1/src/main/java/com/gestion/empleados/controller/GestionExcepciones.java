package com.gestion.empleados.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = {"com.gestion.empleados"})
public class GestionExcepciones {

	//para cada tipo de excepciones 
	@ExceptionHandler(StringIndexOutOfBoundsException.class)
	public ResponseEntity<?> gestionStringoutIndexException(StringIndexOutOfBoundsException ex){
		ResponseEntity<?> responseEntity=null;
		responseEntity=ResponseEntity.internalServerError().body(ex.getMessage());
		System.err.println(responseEntity);		
		return responseEntity;
	}
	
	
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<?> gesGenerico(Throwable ex){
		ResponseEntity<?> responseEntity=null;
		responseEntity=ResponseEntity.internalServerError().body(
				"Error generico y no hay registros "+ex.getMessage());
		System.err.println(responseEntity);		
		return responseEntity;
	}
}
