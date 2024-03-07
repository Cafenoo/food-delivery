package com.innowise.customerservice.controller.advice;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.notFound;

import com.innowise.customerservice.exception.GatewayNotProcessedException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<Void> handleEntityNotFoundException() {
    return notFound().build();
  }

  @ExceptionHandler(GatewayNotProcessedException.class)
  public ResponseEntity<Void> handleGatewayNotProcessedException() {
    return badRequest().build();
  }
}
