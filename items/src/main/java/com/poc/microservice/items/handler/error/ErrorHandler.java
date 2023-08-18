package com.poc.microservice.items.handler.error;

import com.poc.microservice.items.model.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {HttpClientErrorException.BadRequest.class})
    protected ResponseEntity<ErrorMessage> badRequestHandler(RuntimeException ex, WebRequest request) {
        ErrorMessage er = new ErrorMessage("200", "azul", "aqui");
        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }
}
