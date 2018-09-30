package com.handson.micdomingues.musica.model;

import org.hibernate.search.annotations.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "artistas")
public class Artista {

    @Id
    @Column(name = "id")
    private String id;

    @Fields({
            @Field(analyze = Analyze.YES, store = Store.YES, index = Index.YES),
            @Field(name = "sortArtistaNome", analyze = Analyze.NO, store = Store.NO, index = Index.NO)
    })
    @SortableField(forField = "sortArtistaNome")
    @Column(name = "nome")
    private String nome;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artista artista = (Artista) o;
        return Objects.equals(id, artista.id) &&
                Objects.equals(nome, artista.nome);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nome);
    }
}
