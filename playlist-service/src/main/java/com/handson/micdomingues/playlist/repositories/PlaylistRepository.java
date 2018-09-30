package com.handson.micdomingues.playlist.repositories;

import com.handson.micdomingues.playlist.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, String> {

    @Query(
            value = "SELECT m.id AS id, m.nome AS nome, a.nome AS artista FROM musicas m " +
                    "    inner join PlaylistMusicas pm ON pm.MusicaId = m.id " +
                    "    inner join artistas a ON a.id = m.ArtistaId " +
                    "    where pm.PlaylistId = :playlistId " +
                    "    order by a.nome ASC, m.nome ASC",
            nativeQuery = true)
    List<Object[]> findAllMusicasByPlaylistId(@Param("playlistId") String playlistId);
}
