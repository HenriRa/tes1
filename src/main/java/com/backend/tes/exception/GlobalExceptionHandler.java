package com.backend.tes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends DefaultHandlerExceptionResolver {

    @ExceptionHandler(value = {RecordNotFoundException.class})
    public ResponseEntity<ErrorObject> handleRecordNotFoundException(RecordNotFoundException ex, WebRequest request) {
        ErrorObject errorObject = new ErrorObject(HttpStatus.NOT_FOUND.value(),ex.getMessage(), new Date());
        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<ErrorObject> handleRuntimeException(RuntimeException ex, WebRequest request) {
        ErrorObject errorObject = new ErrorObject(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage(), new Date());
        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
