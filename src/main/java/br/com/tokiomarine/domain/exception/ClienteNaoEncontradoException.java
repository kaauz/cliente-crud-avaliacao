package br.com.tokiomarine.domain.exception;

import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class ClienteNaoEncontradoException extends NestedRuntimeException {

    public ClienteNaoEncontradoException(String message) { super(message); }
}
