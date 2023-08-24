package br.com.bruno.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupporteMathOperationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnsupporteMathOperationException(String s) {
        super(s);
    }
}
