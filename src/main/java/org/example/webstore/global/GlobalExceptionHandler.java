package org.example.webstore.global;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.example.webstore.global.exception.IllegalImageTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<?>> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(
            e.getBindingResult().getAllErrors().stream().map(error -> {
                var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, error.getDefaultMessage());
                problemDetail.setTitle("Constraint Violation");
                return problemDetail;
            }).toList()
        );
    }

    @ExceptionHandler(IllegalImageTypeException.class)
    public ResponseEntity<String> handleInvalidImageTypeException(IllegalImageTypeException e)  {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
