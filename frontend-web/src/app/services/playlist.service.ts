import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable()
export class PlaylistService {
  private pathUrlPlaylist = environment.pathUrl + 'playlist';

  public musicas: Array<any>;

  constructor(private httpClient: HttpClient) { }

  filtrarPlaylist(term: string) {
    return this.httpClient.get(`${this.pathUrlPlaylist}/api/playlists?user=${term}`);
  }

  addMusicasParaPlaylist(playlistId: string, musicasIds: Array<string>) {
    return this.httpClient.put(`${this.pathUrlPlaylist}/api/playlists/${playlistId}/musicas`, musicasIds);
  }

  removeMusicaDaPlaylist(playlistId: string, musicaId: Array<string>) {
    return this.httpClient.delete(`${this.pathUrlPlaylist}/api/playlists/${playlistId}/musicas/${musicaId}`);
  }

}
