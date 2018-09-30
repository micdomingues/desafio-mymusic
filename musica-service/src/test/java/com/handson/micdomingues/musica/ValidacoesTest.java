package com.handson.micdomingues.musica;

import com.handson.micdomingues.musica.controllers.validators.ValidacoesMusica;
import com.handson.micdomingues.musica.exceptions.ParametrosException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ValidacoesTest {

    @InjectMocks
    ValidacoesMusica validacoesMusica;

    @Test(expected = ParametrosException.class)
    public void test_limite_caracteres_invalido() {
        this.validacoesMusica.validaLimiteCaracteres("12");
    }

    @Test
    public void test_limite_caracteres_valido() {
        this.validacoesMusica.validaLimiteCaracteres("123");
    }

}
