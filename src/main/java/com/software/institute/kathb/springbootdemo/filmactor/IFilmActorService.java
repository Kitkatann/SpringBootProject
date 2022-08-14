package com.software.institute.kathb.springbootdemo.filmactor;


import java.util.Set;

public interface IFilmActorService {

    void createFilmActors(Integer filmId, Set<Integer> actorIds);
    void updateFilmActors(Integer filmId, Set<Integer> actorIds);
    void deleteFilmActors(Integer filmId);
}
