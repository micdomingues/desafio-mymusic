package com.handson.micdomingues.playlist.controllers.validators;

import com.handson.micdomingues.playlist.exceptions.BusinessException;
import com.handson.micdomingues.playlist.exceptions.mensagens.ErrorMessages;
import com.handson.micdomingues.playlist.model.Playlist;
import com.handson.micdomingues.playlist.model.PlaylistMusica;
import com.handson.micdomingues.playlist.model.PlaylistMusicaPK;
import com.handson.micdomingues.playlist.repositories.PlaylistMusicaRepository;
import com.handson.micdomingues.playlist.repositories.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidacoesPlaylist {

    private final PlaylistRepository playlistRepository;
    private final PlaylistMusicaRepository playlistMusicaRepository;

    @Autowired
    public ValidacoesPlaylist(PlaylistRepository playlistRepository, PlaylistMusicaRepository playlistMusicaRepository) {
        this.playlistRepository = playlistRepository;
        this.playlistMusicaRepository = playlistMusicaRepository;
    }

    public void existePlaylist(String playlistId) throws BusinessException {
        Optional<Playlist> optionalPlaylist = playlistRepository.findById(playlistId);
        optionalPlaylist.orElseThrow(() -> new BusinessException(ErrorMessages.NAO_ENCONTRADO));

    }

    public void existeMusicaOuPlaylist(String playlistId, String musicaId) throws BusinessException {
        Optional<PlaylistMusica> optionalPlaylistMusica = playlistMusicaRepository.findById(new PlaylistMusicaPK(playlistId, musicaId));
        optionalPlaylistMusica.orElseThrow(() -> new BusinessException(ErrorMessages.NAO_ENCONTRADO));
    }

}
