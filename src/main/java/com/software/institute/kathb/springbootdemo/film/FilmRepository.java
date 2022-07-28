package com.software.institute.kathb.springbootdemo.film;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRepository extends CrudRepository<Film, Integer> {

    Iterable<Film> findByTitle(String title);

    List<Film> findByFilmCategoriesName(String categoryName);

    List<Film> findByFilmActorsFirstNameAndFilmActorsLastName(String firstName, String lastName);
}
