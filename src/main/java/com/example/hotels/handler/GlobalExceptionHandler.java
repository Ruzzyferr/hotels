package com.example.hotels.handler;

import com.example.hotels.exception.GenericServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({ GenericServiceException.class })
    public ResponseEntity<?> handleGenericServiceException(GenericServiceException e) {
        log.error(e.getDescription(), e);
        return new ResponseEntity<>(e.getErrorType(), HttpStatus.CONFLICT);
    }

}
