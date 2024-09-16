package com.fq.restspp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApplicationError> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        ApplicationError applicationError = new ApplicationError("BAD_REQUEST", errors.toString());
        return new ResponseEntity<>(applicationError ,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ApplicationError> handleUserNotFound(UserNotFound userNotFound) {
        ApplicationError applicationError = new ApplicationError("BAD_REQUEST", userNotFound.getMessage());
        return new ResponseEntity<>(applicationError ,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AddressNotFound.class)
    public ResponseEntity<ApplicationError> handleAddressNotFound(AddressNotFound ex) {
        ApplicationError applicationError = new ApplicationError("BAD_REQUEST", ex.getMessage());
        return new ResponseEntity<>(applicationError, HttpStatus.BAD_REQUEST);
    }
}
