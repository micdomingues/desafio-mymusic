package com.handson.micdomingues.musica.controllers.validators;

import com.handson.micdomingues.musica.exceptions.ParametrosException;
import com.handson.micdomingues.musica.exceptions.mensagens.ErrorMessages;
import com.handson.micdomingues.musica.repositories.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacoesMusica {

    private static int LIMITE_CARACTERES = 3;

    private final MusicaRepository musicaRepository;

    @Autowired
    public ValidacoesMusica(MusicaRepository musicaRepository) {
        this.musicaRepository = musicaRepository;
    }

    public void validaLimiteCaracteres(String term)  {
        if (term == null || term.length() < LIMITE_CARACTERES) {
            throw new ParametrosException(ErrorMessages.MINIMO_CARACATERES_NAO_ATINGIDO);
        }

    }

}
