package com.example.MediCure.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.MediCure.payloads.ResponseMsg;

@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Resource Not Found Exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseMsg> handleResourceNotFound(ResourceNotFoundException ex) {
        String msg = ex.getMessage();
        ResponseMsg response = new ResponseMsg(msg, false);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // Validation Exception Handler
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseMsg> illegalArgument(IllegalArgumentException ex) {
        String msg = ex.getMessage();
        ResponseMsg response = new ResponseMsg(msg, false);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
