import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { TableMusicComponent } from './table-music.component';


describe('BannerComponent', () => {
  let component: TableMusicComponent;
  let fixture: ComponentFixture<TableMusicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableMusicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableMusicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeDefined();
  });
});
