package com.darwinfont.presta_category.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler {
    @ExceptionHandler(BussinessException.class)
    public ResponseEntity<?> handlerExceptionHandler(BussinessException exception) {
        log.error(exception.getMessage(), exception.getCode());
        var err = ApiExceptionMessage.builder()
                .message(exception.getMessage())
                .error(exception.getCode())
                .build();
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
            NotFoundException.class
    })
    public ResponseEntity<?> handlerNotFoundException(NotFoundException exception) {
        log.error(exception.getMessage(),exception.getCode());
        ApiExceptionMessage err = ApiExceptionMessage.builder()
                .error(exception.getCode())
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            BadRequestException.class
    })
    public ResponseEntity<ApiExceptionMessage<String>> handlerBadRequestException(BadRequestException exception) {

        ApiExceptionMessage<String> err = new ApiExceptionMessage<String>(exception.getCode(), exception.getMessage());

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiExceptionMessage<Map<String, String>>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        ApiExceptionMessage<Map<String, String>> errors =
                new ApiExceptionMessage<Map<String, String>>(HttpStatus.BAD_REQUEST.value(), new HashMap<String, String>());

        ex.getFieldErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.getMessage().put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
