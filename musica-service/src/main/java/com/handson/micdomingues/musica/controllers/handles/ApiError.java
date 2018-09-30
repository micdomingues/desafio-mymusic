package com.handson.micdomingues.musica.controllers.handles;

public class ApiError {
    String mensagem;

    public ApiError(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
