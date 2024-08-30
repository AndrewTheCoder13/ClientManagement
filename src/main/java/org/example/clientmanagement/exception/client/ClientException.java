package org.example.clientmanagement.exception.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ClientException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ClientNotFound.class)
    protected ResponseEntity handlerMaxLimitException(){
        return ResponseEntity.notFound().build();
    }

}
