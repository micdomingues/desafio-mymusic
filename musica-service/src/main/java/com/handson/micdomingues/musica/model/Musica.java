package com.handson.micdomingues.musica.model;

import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "musicas")
@Indexed
public class Musica {

    @Id
    @Column(name = "id")
    private String id;

    @Fields({
            @Field(analyze = Analyze.YES, store = Store.YES, index = Index.YES),
            @Field(name = "sortMusicasNome", analyze = Analyze.NO, store = Store.NO, index = Index.NO)
    })
    @SortableField(forField = "sortMusicasNome")
    @Column(name = "nome")
    private String nome;


    @ManyToOne
    @JoinColumn(name = "artistaid")
    @IndexedEmbedded
    private Artista artista;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musica musica = (Musica) o;
        return Objects.equals(id, musica.id) &&
                Objects.equals(nome, musica.nome) &&
                Objects.equals(artista, musica.artista);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nome, artista);
    }
}




