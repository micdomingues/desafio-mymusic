package com.handson.micdomingues.playlist.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "playlists")
public class Playlist {

    @Id
    @Column(name = "id")
    private String id;

    @OneToOne(mappedBy = "playlist", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Usuario usuario;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(id, playlist.id) &&
                Objects.equals(usuario, playlist.usuario);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, usuario);
    }
}
