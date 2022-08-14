package com.software.institute.kathb.springbootdemo.filmcategory;

import java.util.Set;

public interface IFilmCategoryService {

    void createFilmCategories(Integer filmId, Set<Integer> categoryIds);
    void updateFilmCategories(Integer filmId, Set<Integer> categoryIds);
    void deleteFilmCategories(Integer filmId);
}
