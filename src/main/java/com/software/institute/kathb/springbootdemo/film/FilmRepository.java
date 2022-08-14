package com.software.institute.kathb.springbootdemo.film;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRepository extends CrudRepository<Film, Integer> {

    List<Film> findByTitleContaining(String title);

    List<Film> findByFilmCategoriesIdCategoryId(Integer categoryId);

    List<Film> findByFilmActorsIdActorId(Integer actorId);

    List<Film> findByFilmLanguageLanguageId(Integer languageId);
}
