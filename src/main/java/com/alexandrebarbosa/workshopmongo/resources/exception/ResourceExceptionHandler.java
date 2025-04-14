package com.alexandrebarbosa.workshopmongo.resources.exception;

import com.alexandrebarbosa.workshopmongo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
          HttpStatus status = HttpStatus.NOT_FOUND;
           StandardError sta = new StandardError(System.currentTimeMillis(),status.value(),"not found",e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(sta);
    }
}

