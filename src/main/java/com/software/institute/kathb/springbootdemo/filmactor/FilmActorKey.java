package com.software.institute.kathb.springbootdemo.filmactor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FilmActorKey implements Serializable {

    @Column(name = "actor_id")
    private int actorId;

    @Column(name = "film_id")
    private int filmId;

    public FilmActorKey()
    {

    }

    public FilmActorKey(int actorId, int filmId)
    {
        this.actorId = actorId;
        this.filmId = filmId;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }
}
