import { Component, OnInit, ViewChild } from '@angular/core';
import { TableMusicComponent } from '../table-music/table-music.component';
import { MusicaService } from '../services/musica.service';
import { PlaylistService } from '../services/playlist.service';
import { NgForm } from '@angular/forms';
import { TranslateMessagesUtils } from '../utils/translate_messages.utils';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  @ViewChild('playlist') playlistTable: TableMusicComponent;
  @ViewChild('musica') musicaTable: TableMusicComponent;

  private playlistId: string = null;
  public musicaErros = new Array<string>();
  public musicaInfos = new Array<string>();
  public playlistInfo = new Array<string>();
  public playlistErros = new Array<string>();
  public carregandoMusicas = false;
  public carregandoMusicasDaPlaylist = false;

  public ultimoUsuarioEncontrado = null;

  constructor(private musicaService: MusicaService, private playlistService: PlaylistService) { }

  ngOnInit() {}

  public getMusicas() {
    return this.musicaService.musicas;
  }

  public getMusicasFromPlaylist() {
    return this.playlistService.musicas;
  }

  buscarMusicas(f: NgForm) {
    if (f.valid) {
      this.carregandoMusicas = true;
      this.musicaErros = new Array();
      this.musicaService.filtrarMusicas(f.value.nome)
        .subscribe((response: Array<any>) => {
          if (response == null) {
            this.musicaService.musicas = new Array();
          } else {
            this.musicaService.musicas = response;
          }
          this.musicaTable.musicasSelecionadas.clear();
          this.carregandoMusicas = false;

        }, error => {
          this.musicaErros.push(TranslateMessagesUtils.getMessageFrom(error.error.mensagem));
          this.carregandoMusicas = false;
        });
    }
  }

  buscarUsuarios(f: NgForm) {
    if (f.valid) {
      this.playlistId = null;
      this.carregandoMusicasDaPlaylist = true;
      this.playlistErros = new Array();
      this.playlistInfo = new Array();

      this.playlistService.filtrarPlaylist(f.value.usuario)
        .subscribe((response: any) => {
          if (response != null) {
            this.playlistService.musicas = response.musicas;
            this.playlistId = response.id;
            this.ultimoUsuarioEncontrado = f.value.usuario;
          } else {
            this.playlistInfo.push('Usuário não encontrado');
            this.playlistService.musicas = null;
            this.ultimoUsuarioEncontrado = null;
          }
          this.carregandoMusicasDaPlaylist = false;
          this.playlistTable.musicasSelecionadas.clear();
        }, error => {
          this.playlistErros.push(TranslateMessagesUtils.getMessageFrom(error.error.mensagem));
          this.carregandoMusicasDaPlaylist = false;
        });
    }
  }

  public addMusicasParaPlaylist(musicas: Set<any>) {
    this.musicaInfos = new Array();

    if (this.playlistId != null) {
      this.carregandoMusicasDaPlaylist = true;
    }

    this.playlistService.addMusicasParaPlaylist(this.playlistId, Array.from(musicas))
      .subscribe(() => {
        this.playlistService.filtrarPlaylist(this.ultimoUsuarioEncontrado)
          .subscribe((response: any) => {
            this.playlistService.musicas = response.musicas;
            this.carregandoMusicasDaPlaylist = false;
            musicas.clear();
          });
      }
        , error => {
          this.carregandoMusicasDaPlaylist = false;
          if (error.error.mensagem === 'validacoes.nao_encontrado') {
            this.musicaInfos.push('Por favor, busque um usuário primeiro');
          }
        });
  }

  public removeMusicaDaPlaylist(musicas: Set<any>) {
    this.playlistInfo = new Array();
    if (musicas == null || musicas.size === 0) {
      this.playlistInfo.push('Por favor, selecione ao menos uma música da Playlist');
    } else {
      this.playlistErros = new Array();
      this.carregandoMusicasDaPlaylist = true;
      this.playlistService.removeMusicaDaPlaylist(this.playlistId, Array.from(musicas))
        .subscribe(() => {
          this.playlistService.filtrarPlaylist(this.ultimoUsuarioEncontrado)
            .subscribe((response: any) => {
              musicas.clear();
              this.playlistService.musicas = response.musicas;
              this.carregandoMusicasDaPlaylist = false;
            });
        }, error => {
          this.carregandoMusicasDaPlaylist = false;
          this.playlistErros.push(TranslateMessagesUtils.getMessageFrom(error.error.mensagem));
        });
    }
  }



}
