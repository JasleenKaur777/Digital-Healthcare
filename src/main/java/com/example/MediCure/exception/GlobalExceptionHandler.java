package com.example.MediCure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.MediCure.payloads.ResponseMsg;

@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ResponseMsg> getResponse(ResourceNotFoundException ex){
		String msg=ex.getMessage();
		ResponseMsg response=new ResponseMsg(msg, false);
		return new ResponseEntity<ResponseMsg>(response,HttpStatus.NOT_FOUND);
	}
}
