package com.handson.micdomingues.playlist.model;

import java.io.Serializable;
import java.util.Objects;

public class PlaylistMusicaPK implements Serializable {

    protected String PlaylistId;
    protected String MusicaId;

    public PlaylistMusicaPK() {
    }

    public PlaylistMusicaPK(String playlistId, String musicaId) {
        PlaylistId = playlistId;
        MusicaId = musicaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaylistMusicaPK that = (PlaylistMusicaPK) o;
        return Objects.equals(PlaylistId, that.PlaylistId) &&
                Objects.equals(MusicaId, that.MusicaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PlaylistId, MusicaId);
    }
}
