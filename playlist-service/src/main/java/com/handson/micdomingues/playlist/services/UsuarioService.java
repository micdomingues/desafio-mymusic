package com.handson.micdomingues.playlist.services;

import com.handson.micdomingues.playlist.DTO.PlaylistDTO;
import com.handson.micdomingues.playlist.exceptions.BusinessException;

public interface UsuarioService {

    PlaylistDTO findPlayListByNome(String nome);
}
