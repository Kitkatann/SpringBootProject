package com.software.institute.kathb.springbootdemo.actor;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface ActorRepository extends CrudRepository<Actor,Integer>{
    Iterable<Actor> findByFirstNameContainingAndLastNameContainingOrderByLastName(String lastName, String firstName);
    Optional<Actor> findDistinctByFirstNameAndLastName(String firstName, String lastName);

    List<Actor> findByActorFilmsFilmFilmId(Integer filmId);
}
