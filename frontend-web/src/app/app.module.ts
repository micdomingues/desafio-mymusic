import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { TableMusicComponent } from './table-music/table-music.component';
import { MusicaService } from './services/musica.service';
import { PlaylistService } from './services/playlist.service';
import { NgxLoadingModule } from 'ngx-loading';
import { MainComponent } from './main/main.component';


@NgModule({
  declarations: [
    AppComponent,
    TableMusicComponent,
    MainComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    NgxLoadingModule.forRoot({}),
  ],
  providers: [MusicaService, PlaylistService],
  bootstrap: [AppComponent]
})
export class AppModule { }
