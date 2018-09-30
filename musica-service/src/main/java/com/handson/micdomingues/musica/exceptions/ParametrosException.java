package com.handson.micdomingues.musica.exceptions;

import com.handson.micdomingues.musica.exceptions.mensagens.ErrorMessages;

public class ParametrosException extends IllegalArgumentException {

    private final ErrorMessages messagem;

    public ParametrosException(ErrorMessages messagem) {
        this.messagem = messagem;
    }


    public ParametrosException(String s, ErrorMessages messagem) {
        super(s);
        this.messagem = messagem;
    }

    public ParametrosException(String message, Throwable cause, ErrorMessages messagem) {
        super(message, cause);
        this.messagem = messagem;
    }

    public ParametrosException(Throwable cause, ErrorMessages messagem) {
        super(cause);
        this.messagem = messagem;
    }

    public ErrorMessages getMessagem() {
        return messagem;
    }

}
