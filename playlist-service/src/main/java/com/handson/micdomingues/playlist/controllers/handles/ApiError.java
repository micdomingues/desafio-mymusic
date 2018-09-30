package com.handson.micdomingues.playlist.controllers.handles;

public class ApiError {
    String mensagem;
    String[] detalhes;

    public ApiError(String mensagem) {
        this.mensagem = mensagem;
    }

    public ApiError(String mensagem, String[] detalhes) {
        this.mensagem = mensagem;
        this.detalhes = detalhes;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String[] getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String[] detalhes) {
        this.detalhes = detalhes;
    }
}
