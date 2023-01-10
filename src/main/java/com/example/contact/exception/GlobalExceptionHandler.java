package com.example.contact.exception;

import com.example.contact.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    ResponseEntity<?> globalExceptionHandle(Exception exp) {
        ErrorResponse response = new ErrorResponse();
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage(exp.getMessage());
        response.setDate_time(new Date().toString());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<?> resourceNotFoundExceptionHandle(ResourceNotFoundException exp) {
        ErrorResponse response = new ErrorResponse();
        response.setStatus(exp.httpStatus.value());
        response.setMessage(exp.getMessage());
        response.setDate_time(new Date().toString());
        return new ResponseEntity<>(response, exp.httpStatus);
    }

}
