package com.handson.micdomingues.playlist.DTO;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class PlaylistDTO implements Serializable {

    private String id;
    private List<MusicaDTO> musicas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PlaylistDTO() {
    }

    public PlaylistDTO(String id, List<MusicaDTO> musicas) {
        this.id = id;
        this.musicas = musicas;
    }

    public List<MusicaDTO> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<MusicaDTO> musicas) {
        this.musicas = musicas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaylistDTO that = (PlaylistDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(musicas, that.musicas);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, musicas);
    }
}
