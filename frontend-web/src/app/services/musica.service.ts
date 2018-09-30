import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable()
export class MusicaService {
  private pathUrlMusica = environment.pathUrl + 'musica';

  public musicas: Array<any>;

  constructor(private httpClient: HttpClient) { }

  filtrarMusicas(term: string) {
    return this.httpClient.get(`${this.pathUrlMusica}/api/musicas?filtro=${term}`);
  }

}
