package com.handson.micdomingues.playlist;

import com.handson.micdomingues.playlist.DTO.MusicaDTO;
import com.handson.micdomingues.playlist.DTO.PlaylistDTO;
import com.handson.micdomingues.playlist.repositories.PlaylistRepository;
import com.handson.micdomingues.playlist.services.impl.PlaylistServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlaylistTest {

    @Mock
    PlaylistRepository playlistRepository;
    @InjectMocks
    PlaylistServiceImpl playlistService;


    @Test
    public void test_montagem_das_musicas_da_playlist() {
        when(playlistRepository.findAllMusicasByPlaylistId(any())).thenReturn(
                Arrays.asList(new Object[]{"id1", "nome1", "artista1"}, new Object[]{"id2", "nome2", "artista2"} ));
        PlaylistDTO allMusicasByPlaylistId = playlistService.findAllMusicasByPlaylistId("1");

        PlaylistDTO playlistDTOExpected = new PlaylistDTO("1",
                Arrays.asList(new MusicaDTO("id1", "nome1", "artista1"), new MusicaDTO("id2", "nome2", "artista2")));

        Assert.assertEquals(playlistDTOExpected, allMusicasByPlaylistId );

    }

}
