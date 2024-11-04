package org.example.webstore.global;

import jakarta.persistence.EntityNotFoundException;
import org.example.webstore.global.exception.IllegalImageTypeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IllegalImageTypeException.class)
    public ResponseEntity<String> handleInvalidImageTypeException(IllegalImageTypeException e)  {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
