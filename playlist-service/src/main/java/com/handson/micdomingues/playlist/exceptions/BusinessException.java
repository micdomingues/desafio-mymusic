package com.handson.micdomingues.playlist.exceptions;

import com.handson.micdomingues.playlist.exceptions.mensagens.ErrorMessages;

public class BusinessException extends Exception {

    private final ErrorMessages messagem;

    public BusinessException(ErrorMessages messagem) {
        this.messagem = messagem;
    }

    public BusinessException(String s, ErrorMessages messagem) {
        super(s);
        this.messagem = messagem;
    }

    public BusinessException(String message, Throwable cause, ErrorMessages messagem) {
        super(message, cause);
        this.messagem = messagem;
    }

    public BusinessException(Throwable cause, ErrorMessages messagem) {
        super(cause);
        this.messagem = messagem;
    }

    public ErrorMessages getMessagem() {
        return messagem;
    }

}
