package com.handson.micdomingues.playlist.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "playlistmusicas")
@IdClass(PlaylistMusicaPK.class)
public class PlaylistMusica implements Serializable {

    @Id
    @Column(name = "playlistid")
    private String PlaylistId;
    @Id
    @Column(name = "musicaid")
    private String MusicaId;

    public String getPlaylistId() {
        return PlaylistId;
    }

    public void setPlaylistId(String playlistId) {
        PlaylistId = playlistId;
    }

    public String getMusicaId() {
        return MusicaId;
    }

    public void setMusicaId(String musicaId) {
        MusicaId = musicaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaylistMusica that = (PlaylistMusica) o;
        return Objects.equals(PlaylistId, that.PlaylistId) &&
                Objects.equals(MusicaId, that.MusicaId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(PlaylistId, MusicaId);
    }
}
