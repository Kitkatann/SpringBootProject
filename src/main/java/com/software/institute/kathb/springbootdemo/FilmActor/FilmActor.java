package com.software.institute.kathb.springbootdemo.FilmActor;

import com.software.institute.kathb.springbootdemo.actor.Actor;
import com.software.institute.kathb.springbootdemo.film.Film;

import javax.persistence.*;

@Entity
public class FilmActor {

    @EmbeddedId
    FilmActorKey id;

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name = "actor_id")
    Actor actor;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id")
    Film film;

    @Column(name="last_update")
    String lastUpdate;

    public FilmActor(Actor actor, Film film) {
        this.actor = actor;
        this.film = film;
    }

    public FilmActor()
    {

    }

    public FilmActorKey getId() {
        return id;
    }

    public void setId(FilmActorKey id) {
        this.id = id;
    }

}
