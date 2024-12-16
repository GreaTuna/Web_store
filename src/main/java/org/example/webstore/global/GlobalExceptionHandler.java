package org.example.webstore.global;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.example.webstore.global.exception.IllegalImageTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public static class Details {
        public String message;
        public long actual ;
        public long permitted;

        public Details(FileSizeLimitExceededException e) {
            this.message = e.getMessage();
            this.actual = e.getActualSize();
            this.permitted = e.getPermittedSize();
        }
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFound() {
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
    public ResponseEntity<String> handleInvalidImageType(IllegalImageTypeException e)  {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(FileSizeLimitExceededException.class)
    public ResponseEntity<Details> handleSizeLimitExceeded(FileSizeLimitExceededException e)  {
        return ResponseEntity.badRequest().body(new Details(e));
    }
}
