package com.handson.micdomingues.playlist.DTO;

import java.io.Serializable;
import java.util.Objects;

public class MusicaDTO implements Serializable {

    private String id;
    private String nome;
    private String artista;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public MusicaDTO() {
    }

    public MusicaDTO(String id, String nome, String artista) {
        this.id = id;
        this.nome = nome;
        this.artista = artista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicaDTO musicaDTO = (MusicaDTO) o;
        return Objects.equals(id, musicaDTO.id) &&
                Objects.equals(nome, musicaDTO.nome) &&
                Objects.equals(artista, musicaDTO.artista);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nome, artista);
    }
}
