package com.handson.micdomingues.playlist.services.impl;

import com.handson.micdomingues.playlist.DTO.MusicaDTO;
import com.handson.micdomingues.playlist.DTO.PlaylistDTO;
import com.handson.micdomingues.playlist.model.PlaylistMusica;
import com.handson.micdomingues.playlist.model.PlaylistMusicaPK;
import com.handson.micdomingues.playlist.repositories.PlaylistMusicaRepository;
import com.handson.micdomingues.playlist.repositories.PlaylistRepository;
import com.handson.micdomingues.playlist.services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository repository;
    private final PlaylistMusicaRepository playlistMusicaRepository;

    private static Function<List<Object[]>, List<MusicaDTO>> transformObjectToMusicaDTO = objects -> {
            List<MusicaDTO> musicaDTOs = new ArrayList<>();
            objects.forEach(object ->
                    musicaDTOs.add(new MusicaDTO(object[0].toString(), object[1].toString(), object[2].toString()))
            );

            return musicaDTOs;
    };

    @Autowired
    public PlaylistServiceImpl(PlaylistRepository playlistRepository, PlaylistMusicaRepository playlistMusicaRepository) {
        this.repository = playlistRepository;
        this.playlistMusicaRepository = playlistMusicaRepository;
    }

    @Transactional
    public void adicionaMusicaAPlaylist(String playlistId, List<String> musicasIds) {

        List<PlaylistMusica> playlistMusicas = new ArrayList<>();
        for (String musicaId : musicasIds) {
            PlaylistMusica playlistMusica = new PlaylistMusica();
            playlistMusica.setMusicaId(musicaId);
            playlistMusica.setPlaylistId(playlistId);
            playlistMusicas.add(playlistMusica);
        }

        playlistMusicaRepository.saveAll(playlistMusicas);

    }

    @Transactional
    public void removeMusicaDaPlaylist(String playlistId, String musicaId) {
        playlistMusicaRepository.deleteById(new PlaylistMusicaPK(playlistId, musicaId));
    }

    @Transactional(readOnly = true)
    public PlaylistDTO findAllMusicasByPlaylistId(String playlistId) {

        List<Object[]> musicasAsObj = this.repository.findAllMusicasByPlaylistId(playlistId);
        List<MusicaDTO> musicas = transformObjectToMusicaDTO.apply(musicasAsObj);
        
        return new PlaylistDTO(playlistId, musicas);
    }
}
