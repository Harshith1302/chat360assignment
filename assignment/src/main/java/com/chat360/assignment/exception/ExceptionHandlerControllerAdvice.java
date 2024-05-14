package com.chat360.assignment.exception;

import com.chat360.assignment.enums.LogLevel;
import com.chat360.assignment.model.Log;
import com.chat360.assignment.service.LogIngestor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @Autowired
    private LogIngestor logIngestor;

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    protected ResponseEntity<String> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        logIngestor.log(new Log(LogLevel.ERROR,ex.getMessage(),"Calculator Controller"));
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<String> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        logIngestor.log(new Log(LogLevel.ERROR,ex.getMessage(),"Calculator Controller"));
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}