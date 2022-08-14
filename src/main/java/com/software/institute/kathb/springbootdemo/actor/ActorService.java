package com.software.institute.kathb.springbootdemo.actor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ActorService implements IActorService{

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository)
    {
        this.actorRepository = actorRepository;
    }

    public List<Actor> getActorsByName(String fullName)
    {
        return actorRepository.findByFullNameContaining(fullName);
    }

    public Actor getActorById(Integer actorId)
    {
        return actorRepository
                .findById(actorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No actor exists with that id"));
    }

    public List<Actor> getActorsByFilm(Integer filmId)
    {
        return actorRepository.findByActorFilmsFilmFilmId(filmId);
    }

    public Integer createActor(ActorDTO actorDTO)
    {
        Actor actor = actorRepository.save(new Actor(actorDTO));
        return actor.getActorId();
    }

    public void updateActor(Integer actorId, ActorDTO actorDTO)
    {
        Actor actor = actorRepository
                .findById(actorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No actor exists with that id"));
        actor.updateFromDTO(actorDTO);
        actorRepository.save(actor);
    }

    public void deleteActor(Integer actorId)
    {
        Actor actor = actorRepository
                .findById(actorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No actor exists with that id"));
        actorRepository.delete(actor);
    }

}
