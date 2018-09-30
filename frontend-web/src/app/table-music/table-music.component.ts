import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-table-music',
  templateUrl: './table-music.component.html',
  styleUrls: ['./table-music.component.css']
})
export class TableMusicComponent implements OnInit {

  @Input()
  public multiple: boolean;
  @Input()
  public musicas;

  public musicasSelecionadas: Set<string> = new Set<string>();

  constructor() { }

  ngOnInit() {
  }

  isChecked(id: string) {
    return this.musicasSelecionadas.has(id);
  }

  check(id: string, check: boolean) {
    if (this.multiple) {
      if (check) {
        this.musicasSelecionadas.add(id);
      } else {
        this.musicasSelecionadas.delete(id);
      }
    } else {
      this.musicasSelecionadas.clear();
      this.musicasSelecionadas.add(id);
    }

  }

  getMusicasSelecionadas() {
    return Array.from(this.musicasSelecionadas);
  }


}
