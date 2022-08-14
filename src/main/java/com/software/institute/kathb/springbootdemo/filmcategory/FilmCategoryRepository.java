package com.software.institute.kathb.springbootdemo.filmcategory;

import org.springframework.data.repository.CrudRepository;

public interface FilmCategoryRepository extends CrudRepository<FilmCategory,Integer> {
    Integer deleteByFilmFilmId(Integer filmId);
}
