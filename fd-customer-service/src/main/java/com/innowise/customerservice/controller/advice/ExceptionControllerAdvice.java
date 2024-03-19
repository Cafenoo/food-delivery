package com.innowise.customerservice.controller.advice;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.notFound;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<Void> handleEntityNotFoundException() {
    return notFound().build();
  }

  @ExceptionHandler(PropertyReferenceException.class)
  public ResponseEntity<Void> handlePropertyReferenceException() {
    return badRequest().build();
  }
}
