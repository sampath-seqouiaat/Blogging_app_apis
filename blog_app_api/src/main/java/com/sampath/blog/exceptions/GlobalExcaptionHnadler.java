package com.sampath.blog.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sampath.blog.playloads.Response;

@RestControllerAdvice
public class GlobalExcaptionHnadler {

@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<Response> resourceNotFoundExceptionHnadler(ResourceNotFoundException ex){
		  
		 String message=ex.getMessage();
		 Response response = new Response("Notfound ",false);
		 return new ResponseEntity<Response>(response,HttpStatus.NOT_FOUND);
		 
}
	 
}
