package com.dh.TFI.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException{
    private final static Logger LOGGER = Logger.getLogger(GlobalException.class);
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> handleResourceNotFound (ResourceNotFoundException e){
        LOGGER.error("NO ENCONTRADO: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> handleBadRequest (BadRequestException e){
        LOGGER.error("BAD REQUEST: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
