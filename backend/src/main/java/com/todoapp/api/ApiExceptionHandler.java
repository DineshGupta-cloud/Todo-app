package com.todoapp.api;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {
  @ExceptionHandler(Exception.class)
  ResponseEntity<Map<String,String>> handle(Exception ex){
    HttpStatus s=ex instanceof java.util.NoSuchElementException ? HttpStatus.NOT_FOUND : HttpStatus.INTERNAL_SERVER_ERROR;
    return ResponseEntity.status(s).body(Map.of("error", s==HttpStatus.NOT_FOUND?"Todo not found":"Internal server error"));
  }
}