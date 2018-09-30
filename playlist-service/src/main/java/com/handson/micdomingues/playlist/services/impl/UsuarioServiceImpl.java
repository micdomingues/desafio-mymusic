package com.handson.micdomingues.playlist.services.impl;

import com.handson.micdomingues.playlist.DTO.PlaylistDTO;
import com.handson.micdomingues.playlist.exceptions.BusinessException;
import com.handson.micdomingues.playlist.exceptions.mensagens.ErrorMessages;
import com.handson.micdomingues.playlist.model.Usuario;
import com.handson.micdomingues.playlist.repositories.UsuarioRepository;
import com.handson.micdomingues.playlist.services.PlaylistService;
import com.handson.micdomingues.playlist.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PlaylistService playlistService;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,
                              PlaylistService playlistService) {
        this.usuarioRepository = usuarioRepository;
        this.playlistService = playlistService;
    }

    public PlaylistDTO findPlayListByNome(String nome)  {
        Usuario usuario = usuarioRepository.findByNome(nome);
        if (usuario == null) {
            return null;
        } else  {
            return this.playlistService.findAllMusicasByPlaylistId(usuario.getPlaylist().getId());
        }
    }
}
