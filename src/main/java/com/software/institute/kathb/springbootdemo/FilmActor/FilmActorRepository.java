package com.software.institute.kathb.springbootdemo.FilmActor;

import com.software.institute.kathb.springbootdemo.film.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmActorRepository extends CrudRepository<FilmActor, Integer> {

    //List<FilmActor> findFilmActorByActorFirstNameAndActorLastName(String actorFirstName, String actorLastName);
}
