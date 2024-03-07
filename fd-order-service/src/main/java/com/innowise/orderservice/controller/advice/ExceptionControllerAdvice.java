package com.innowise.orderservice.controller.advice;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.notFound;

import java.util.NoSuchElementException;
import com.innowise.orderservice.exception.GatewayNotProcessedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<Void> handleNoSuchElementException() {
    return notFound().build();
  }

  @ExceptionHandler(GatewayNotProcessedException.class)
  public ResponseEntity<Void> handleGatewayNotProcessedException() {
    return badRequest().build();
  }
}
