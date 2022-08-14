package com.software.institute.kathb.springbootdemo.actor;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActorRepository extends CrudRepository<Actor,Integer>{
    List<Actor> findByActorFilmsFilmFilmId(Integer filmId);

    List<Actor> findByFullNameContaining(String fullName);
}
