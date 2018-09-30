package com.handson.micdomingues.playlist.exceptions.mensagens;

public enum ErrorMessages {

    ERRO_INTERNO("validacoes.erro_interno"),
    NAO_ENCONTRADO("validacoes.nao_encontrado");

    private String value;

    ErrorMessages(String messagem) {
        this.value = messagem;
    }

    public String getValue() {
        return value;
    }
}
