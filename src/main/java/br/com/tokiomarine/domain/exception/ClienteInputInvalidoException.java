package br.com.tokiomarine.domain.exception;

import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ClienteInputInvalidoException extends NestedRuntimeException {

    public ClienteInputInvalidoException(String message) { super(message); }
}
