package br.com.tokiomarine.controller;

import br.com.tokiomarine.domain.exception.ClienteInputInvalidoException;
import br.com.tokiomarine.domain.exception.ClienteNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ClienteNaoEncontradoException lidarComClienteNaoEncontrado (ClienteNaoEncontradoException ex){
        return ex;
    }

    @ExceptionHandler(ClienteInputInvalidoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ClienteInputInvalidoException lidarComClienteNaoEncontrado (ClienteInputInvalidoException ex){
        return ex;
    }

}
