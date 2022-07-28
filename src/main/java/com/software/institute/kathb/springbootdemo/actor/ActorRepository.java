package com.software.institute.kathb.springbootdemo.actor;

import com.software.institute.kathb.springbootdemo.film.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ActorRepository extends CrudRepository<Actor,Integer>{
    Iterable<Actor> findByFirstNameContainingAndLastNameContainingOrderByLastName(String lastName, String firstName);
    Actor findDistinctByFirstNameAndLastName(String firstName, String lastName);

    //List<Film> findByFilmActorsFirstNameAndFilmActorsLastName(String firstName, String lastName);
}
