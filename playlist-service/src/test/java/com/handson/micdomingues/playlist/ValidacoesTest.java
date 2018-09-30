package com.handson.micdomingues.playlist;

import com.handson.micdomingues.playlist.controllers.validators.ValidacoesPlaylist;
import com.handson.micdomingues.playlist.exceptions.BusinessException;
import com.handson.micdomingues.playlist.model.PlaylistMusicaPK;
import com.handson.micdomingues.playlist.repositories.PlaylistMusicaRepository;
import com.handson.micdomingues.playlist.repositories.PlaylistRepository;
import com.handson.micdomingues.playlist.repositories.UsuarioRepository;
import com.handson.micdomingues.playlist.services.impl.UsuarioServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ValidacoesTest {

    @Mock
    PlaylistRepository playlistRepository;
    @Mock
    PlaylistMusicaRepository playlistMusicaRepository;
    @InjectMocks
    ValidacoesPlaylist validacoesPlaylist;


    @Test(expected = BusinessException.class)
    public void test_playlist_nao_encontrada() throws BusinessException {
        when(playlistRepository.findById(any())).thenReturn(Optional.empty());
        validacoesPlaylist.existePlaylist("id_inexistente");

    }

    @Test(expected = BusinessException.class)
    public void test_playlist_ou_musica_nao_encontrada() throws BusinessException {
        when(playlistMusicaRepository.findById(any(PlaylistMusicaPK.class))).thenReturn(Optional.empty());
        validacoesPlaylist.existeMusicaOuPlaylist("playlist_id_invalida", "musica_id_invalida");

    }
}
