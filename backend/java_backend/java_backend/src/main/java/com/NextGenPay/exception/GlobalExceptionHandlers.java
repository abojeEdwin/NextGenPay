package com.NextGenPay.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandlers {

        private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandlers.class);

        @ExceptionHandler(CustomerNotFoundException.class)
        public ResponseEntity<String> handleUserNotFound(CustomerNotFoundException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(EmailAlreadyExistException.class)
        public ResponseEntity<String> handleEmailAlreadyExist(EmailAlreadyExistException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }

        @ExceptionHandler(InvalidPasswordException.class)
        public ResponseEntity<String> handleInvalidPassword(InvalidPasswordException ex) {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.UNAUTHORIZED);
        }


        @ExceptionHandler(InvalidEmailException.class)
        public ResponseEntity<String> handleInvalidEmail(InvalidEmailException ex) {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleAll(Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
            Map<String, String> errors = new HashMap<>();
            ex.getBindingResult().getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage()));
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

    }

