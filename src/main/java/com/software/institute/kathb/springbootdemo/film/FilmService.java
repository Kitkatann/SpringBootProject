package com.software.institute.kathb.springbootdemo.film;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FilmService implements IFilmService{

    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository)
    {
        this.filmRepository = filmRepository;
    }

    public Film getFilmById(Integer filmId)
    {
        return filmRepository
                .findById(filmId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No film exists with that id"));
    }

    public List<Film> getFilmsByTitle(String title)
    {
        return filmRepository.findByTitleContaining(title);
    }

    public List<Film> getFilmsByCategory(Integer categoryId)
    {
        return filmRepository.findByFilmCategoriesIdCategoryId(categoryId);
    }

    public List<Film> getFilmsByLanguage(Integer languageId)
    {
        return filmRepository.findByFilmLanguageLanguageId(languageId);
    }

    public List<Film> getFilmsByActor(Integer actorId)
    {
        return filmRepository.findByFilmActorsIdActorId(actorId);
    }

    public Integer createFilm(FilmDTO filmDTO)
    {
        Film film = filmRepository.save(new Film(filmDTO));
        return film.getFilmId();
    }

    public void updateFilm(Integer filmId, FilmDTO filmDTO)
    {
        Film film = filmRepository
                .findById(filmId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No film exists with that id"));
        film.updateFromDTO(filmDTO);
        filmRepository.save(film);
    }

    public void deleteFilm(Integer filmId)
    {
        Film film = filmRepository
                .findById(filmId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No film exists with that id"));
        filmRepository.delete(film);
    }

}
