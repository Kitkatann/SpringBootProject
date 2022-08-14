package com.software.institute.kathb.springbootdemo.filmactor;

import com.software.institute.kathb.springbootdemo.actor.Actor;
import com.software.institute.kathb.springbootdemo.actor.ActorRepository;
import com.software.institute.kathb.springbootdemo.film.Film;
import com.software.institute.kathb.springbootdemo.film.FilmRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@Service
public class FilmActorService implements IFilmActorService{

    private final FilmActorRepository filmActorRepository;
    private final FilmRepository filmRepository;
    private final ActorRepository actorRepository;

    public FilmActorService(FilmActorRepository filmActorRepository, FilmRepository filmRepository, ActorRepository actorRepository)
    {
        this.filmActorRepository = filmActorRepository;
        this.filmRepository = filmRepository;
        this.actorRepository = actorRepository;
    }

    public void createFilmActors(Integer filmId, Set<Integer> actorIds)
    {
        Film film = filmRepository
                .findById(filmId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No film exists with that id"));
        for (Integer actorId : actorIds)
        {
            Actor actor = actorRepository
                    .findById(actorId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No actor exists with that id"));
            filmActorRepository.save(new FilmActor(actor, film));
        }
    }

    public void updateFilmActors(Integer filmId, Set<Integer> actorIds)
    {
        deleteFilmActors(filmId);
        createFilmActors(filmId, actorIds);
    }

    public void deleteFilmActors(Integer filmId)
    {
        filmActorRepository.deleteByFilmFilmId(filmId);
    }
}
