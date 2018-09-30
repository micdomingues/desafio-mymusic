package com.handson.micdomingues.playlist.services;

import com.handson.micdomingues.playlist.DTO.PlaylistDTO;

import java.util.List;

public interface PlaylistService {

    void adicionaMusicaAPlaylist(String playlistId, List<String> musicasIds);

    void removeMusicaDaPlaylist(String playlistId, String musicaId);

    PlaylistDTO findAllMusicasByPlaylistId(String playlistId);
}
