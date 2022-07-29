package com.software.institute.kathb.springbootdemo.film;

import com.software.institute.kathb.springbootdemo.language.Language;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRepository extends CrudRepository<Film, Integer> {

    Iterable<Film> findByTitleContainingOrderByTitle(String title);

    List<Film> findByFilmCategoriesName(String categoryName);

    List<Film> findByTitleContainingAndFilmCategoriesNameOrderByTitle(String title, String categoryName);

    List<Film> findByFilmActorsIdActorId(int actorId);

    List<Film> findByFilmLanguageName(String name);
}
