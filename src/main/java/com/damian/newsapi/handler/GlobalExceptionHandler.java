package com.damian.newsapi.handler;

import com.damian.newsapi.exception.InvalidNewsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidNewsException.class)
    public ResponseEntity<String> handleInvalidNewsException(InvalidNewsException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
