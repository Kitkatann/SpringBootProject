package com.software.institute.kathb.springbootdemo.film;

import java.util.List;

public interface IFilmService {

    Film getFilmById(Integer filmId);
    List<Film> getFilmsByTitle(String title);

    List<Film> getFilmsByCategory(Integer categoryId);

    List<Film> getFilmsByLanguage(Integer languageId);

    List<Film> getFilmsByActor(Integer actorId);

    Integer createFilm(FilmDTO filmDTO);

    void updateFilm(Integer filmId, FilmDTO filmDTO);

    void deleteFilm(Integer filmId);
}
