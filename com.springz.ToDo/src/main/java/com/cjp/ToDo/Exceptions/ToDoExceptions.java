package com.cjp.ToDo.Exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ToDoExceptions extends RuntimeException {
	
	private String message;
	private HttpStatus httpStatus;
	
	
	public ToDoExceptions(String message, HttpStatus httpStatus) {
		
		super(message);
		this.message = message;
		this.httpStatus = httpStatus;
}


	public HttpStatus getHttpStatus() {
		// TODO Esbozo de método generado automáticamente
		return this.httpStatus;
	}


}
