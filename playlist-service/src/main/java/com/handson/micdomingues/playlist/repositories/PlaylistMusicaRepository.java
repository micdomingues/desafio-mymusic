package com.handson.micdomingues.playlist.repositories;

import com.handson.micdomingues.playlist.model.PlaylistMusica;
import com.handson.micdomingues.playlist.model.PlaylistMusicaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistMusicaRepository extends JpaRepository<PlaylistMusica, PlaylistMusicaPK> {

}
