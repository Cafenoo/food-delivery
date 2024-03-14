package com.innowise.orderservice.controller.advice;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.notFound;

import com.innowise.orderservice.exception.RecordNotFoundException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

  @ExceptionHandler(RecordNotFoundException.class)
  public ResponseEntity<Void> handleRecordNotFoundException() {
    return notFound().build();
  }

  @ExceptionHandler(PropertyReferenceException.class)
  public ResponseEntity<Void> handlePropertyReferenceException() {
    return badRequest().build();
  }
}
