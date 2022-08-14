package com.software.institute.kathb.springbootdemo.actor;

import java.util.List;

public interface IActorService {

    List<Actor> getActorsByName(String name);

    Actor getActorById(Integer actorId);

    List<Actor> getActorsByFilm(Integer filmId);

    Integer createActor(ActorDTO actorDTO);

    void updateActor(Integer actorId, ActorDTO actorDTO);

    void deleteActor(Integer actorId);
}
