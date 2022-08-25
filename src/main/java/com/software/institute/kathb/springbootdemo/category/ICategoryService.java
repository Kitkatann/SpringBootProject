package com.software.institute.kathb.springbootdemo.category;


public interface ICategoryService {
    Iterable<Category> getAllCategories();

    Iterable<Category> getCategoriesByFilm(Integer filmId);
}
