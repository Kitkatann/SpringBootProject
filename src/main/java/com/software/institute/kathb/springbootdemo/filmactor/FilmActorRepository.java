package com.software.institute.kathb.springbootdemo.filmactor;

import com.software.institute.kathb.springbootdemo.actor.Actor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FilmActorRepository extends CrudRepository<FilmActor, Integer> {

    Optional<FilmActor> findByActorActorIdAndFilmFilmId(Integer actorId, Integer filmId);

}
