package com.software.institute.kathb.springbootdemo.FilmActor;

import com.software.institute.kathb.springbootdemo.actor.Actor;
import com.software.institute.kathb.springbootdemo.actor.ActorRepository;
import com.software.institute.kathb.springbootdemo.film.Film;
import com.software.institute.kathb.springbootdemo.film.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        Actor actor = actorRepository.findDistinctByFirstNameAndLastName(firstName, lastName);
        return filmRepository.findByFilmActorsIdActorId(actor.getActorId());
    }


}
