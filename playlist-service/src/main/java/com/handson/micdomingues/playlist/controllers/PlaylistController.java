package com.handson.micdomingues.playlist.controllers;

import com.handson.micdomingues.playlist.DTO.PlaylistDTO;
import com.handson.micdomingues.playlist.controllers.validators.ValidacoesPlaylist;
import com.handson.micdomingues.playlist.exceptions.BusinessException;
import com.handson.micdomingues.playlist.services.PlaylistService;
import com.handson.micdomingues.playlist.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/playlists")
@CrossOrigin(origins = "*")
public class PlaylistController {

    private final UsuarioService usuarioService;
    private final PlaylistService playlistService;
    private final ValidacoesPlaylist validacoesPlaylist;

    @Autowired
    public PlaylistController(UsuarioService usuarioService, PlaylistService playlistService, ValidacoesPlaylist validacoesPlaylist) {
        this.usuarioService = usuarioService;
        this.playlistService = playlistService;
        this.validacoesPlaylist = validacoesPlaylist;
    }

    @GetMapping
    public ResponseEntity<PlaylistDTO> buscaPlaylistPorUsuario(@RequestParam(value = "user") String nome) {
        PlaylistDTO playListByNome = usuarioService.findPlayListByNome(nome);
        if (playListByNome == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(playListByNome);
    }

    @PutMapping(value = "/{playlistId}/musicas")
    public ResponseEntity<Void> adicionarMusicaAPlaylist(@PathVariable(value = "playlistId") String playlistId,
                                                         @RequestBody List<String> musicasIds) throws BusinessException {

        validacoesPlaylist.existePlaylist(playlistId);

        playlistService.adicionaMusicaAPlaylist(playlistId, musicasIds);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{playlistId}/musicas/{musicaId}")
    public ResponseEntity<Void> removeMusicaDaPlaylist(@PathVariable(value = "playlistId") String playlistId,
                                                       @PathVariable(value = "musicaId") String musicaId) throws BusinessException {

        validacoesPlaylist.existeMusicaOuPlaylist(playlistId, musicaId);

        playlistService.removeMusicaDaPlaylist(playlistId, musicaId);

        return ResponseEntity.ok().build();
    }
}
