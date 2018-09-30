package com.handson.micdomingues.musica.controllers;

import com.handson.micdomingues.musica.DTO.MusicaDTO;
import com.handson.micdomingues.musica.controllers.validators.ValidacoesMusica;
import com.handson.micdomingues.musica.services.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/musicas")
@CrossOrigin(origins = "*")
public class MusicaController {

    private final MusicaService musicaService;
    private final ValidacoesMusica validacoesMusica;

    @Autowired
    public MusicaController(MusicaService musicaService, ValidacoesMusica validacoesMusica) {
        this.musicaService = musicaService;
        this.validacoesMusica = validacoesMusica;
    }

    @GetMapping
    public ResponseEntity<List<MusicaDTO>> filtro(@RequestParam(value = "filtro", required = false) String term) {

        validacoesMusica.validaLimiteCaracteres(term);

        List<MusicaDTO> musicas = musicaService.filtrarMusicas(term);

        if (musicas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(musicas);
    }
}