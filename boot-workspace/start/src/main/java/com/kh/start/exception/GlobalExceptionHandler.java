package com.kh.start.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IdDuplicateException.class)
	public ResponseEntity<?> handlerDuplicateId(IdDuplicateException e){
		
		Map<String,String> error = new HashMap();
		error.put("error-message", e.getMessage());
		return ResponseEntity.badRequest().body(error);
		
	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handlerArgumentsNotValid(MethodArgumentNotValidException e){
		
		/*
		List<FieldError> list =  e.getBindingResult().getFieldErrors();
		
		for(int i=0; i< list.size(); i++) {
			log.info("예외 발생 필드명 : {} , 발생한 이유 : {}" , list.get(i).getField(),list.get(i).getDefaultMessage());
		}*/
		
		Map<String,String> errors = new HashMap<>();
		e.getBindingResult().getFieldErrors()
		.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		return ResponseEntity.badRequest().body(errors);
		
		
	}
	
	
	
	
}
