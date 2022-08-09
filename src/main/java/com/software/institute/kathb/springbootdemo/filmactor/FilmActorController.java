package com.software.institute.kathb.springbootdemo.filmactor;

import com.software.institute.kathb.springbootdemo.actor.Actor;
import com.software.institute.kathb.springbootdemo.actor.ActorRepository;
import com.software.institute.kathb.springbootdemo.category.Category;
import com.software.institute.kathb.springbootdemo.film.Film;
import com.software.institute.kathb.springbootdemo.film.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/filmActor")
public class FilmActorController {

    @Autowired
    private final FilmActorRepository filmActorRepository;

    @Autowired
    private final FilmRepository filmRepository;

    @Autowired
    private final ActorRepository actorRepository;

    public FilmActorController(FilmActorRepository filmActorRepository,
                               FilmRepository filmRepository,
                               ActorRepository actorRepository)
    {
        this.filmActorRepository = filmActorRepository;
        this.filmRepository = filmRepository;
        this.actorRepository = actorRepository;
    }

    @GetMapping(params = {"actorFirstName", "actorLastName"})
    public @ResponseBody
    List<Film> getFilmsByActor(@RequestParam(name = "actorFirstName") String firstName,
                               @RequestParam(name = "actorLastName") String lastName)
    {
        Actor actor = actorRepository
                .findDistinctByFirstNameAndLastName(firstName, lastName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No actor exists with that name"));
        return filmRepository.findByFilmActorsIdActorId(actor.getActorId());
    }

    @GetMapping()
    public @ResponseBody
    Iterable<FilmActor>getAllFilmActors()
    {
        return filmActorRepository.findAll();
    }

    @PostMapping(params = {"actorFirstName", "actorLastName", "filmId"})
    public @ResponseBody
    String addActorToFilm(@RequestParam(name = "actorFirstName") String firstName,
                          @RequestParam(name = "actorLastName") String lastName,
                          @RequestParam(name = "filmId") Integer filmId)
    {
        Actor actor = actorRepository
                .findDistinctByFirstNameAndLastName(firstName, lastName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No actor exists with that name"));
        Film film = filmRepository
                .findById(filmId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No film exists with that id"));
        System.out.println(actor.getActorId() + " " + film.getFilmId());
        FilmActor filmActor = new FilmActor(actor, film);
        filmActorRepository.save(filmActor);
        return "saved";
    }

    @DeleteMapping(params = {"actorFirstName", "actorLastName", "filmId"})
    public @ResponseBody
    void deleteFilmActor(@RequestParam(name = "actorFirstName") String firstName,
                           @RequestParam(name = "actorLastName") String lastName,
                           @RequestParam(name = "filmId") Integer filmId)
    {
        Integer actorId = actorRepository
                .findDistinctByFirstNameAndLastName(firstName, lastName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No actor exists with that name"))
                .getActorId();
        FilmActor filmActor = filmActorRepository
                .findByActorActorIdAndFilmFilmId(actorId, filmId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No film actor exists for that film and actor"));
        filmActorRepository.delete(filmActor);
    }


}
