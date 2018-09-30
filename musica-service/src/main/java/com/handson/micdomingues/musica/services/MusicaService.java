package com.handson.micdomingues.musica.services;

import com.handson.micdomingues.musica.DTO.MusicaDTO;
import com.handson.micdomingues.musica.model.Musica;
import com.handson.micdomingues.musica.repositories.MusicaRepository;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class MusicaService {

    private final MusicaRepository musicaRepository;

    @Autowired
    EntityManager entityManager;

    @Autowired
    public MusicaService(MusicaRepository musicaRepository) {
        this.musicaRepository = musicaRepository;
    }

    @Transactional(readOnly = true)
    public List<MusicaDTO> filtrarMusicas(String filtro) {

        FullTextEntityManager fullTextEntityManager
                = Search.getFullTextEntityManager(entityManager);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Musica.class)
                .get();

        Query query = queryBuilder
                .keyword()
                .onFields("nome", "artista.nome")
                .matching(filtro)
                .createQuery();


        FullTextQuery jpaQuery
                = fullTextEntityManager.createFullTextQuery(query, Musica.class);

        Sort sort = new Sort(
                SortField.FIELD_SCORE,
                new SortField("artista.sortArtistaNome", SortField.Type.STRING),
                new SortField("sortMusicasNome", SortField.Type.STRING)
        );

        jpaQuery.setSort(sort);

        jpaQuery.setProjection( "id", "nome", "artista.nome" );

        jpaQuery.setResultTransformer(
                new ResultTransformer() {
                    @Override
                    public Object transformTuple(
                            Object[] tuple,
                            String[] aliases) {
                        return new MusicaDTO(
                                (String) tuple[0],
                                (String) tuple[1],
                                (String) tuple[2]
                        );
                    }

                    @Override
                    public List transformList(List collection) {
                        return collection;
                    }
                }
        );

        List<MusicaDTO> resultList = jpaQuery.getResultList();

        return  resultList;
    }



}
