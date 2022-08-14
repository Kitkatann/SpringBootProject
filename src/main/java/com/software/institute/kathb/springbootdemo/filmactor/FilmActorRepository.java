package com.software.institute.kathb.springbootdemo.filmactor;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FilmActorRepository extends CrudRepository<FilmActor, Integer> {

    Optional<FilmActor> findByActorActorIdAndFilmFilmId(Integer actorId, Integer filmId);

    Integer deleteByFilmFilmId(Integer filmId);

}
