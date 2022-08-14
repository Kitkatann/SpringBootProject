package com.software.institute.kathb.springbootdemo.filmcategory;

import com.software.institute.kathb.springbootdemo.category.Category;
import com.software.institute.kathb.springbootdemo.category.CategoryRepository;
import com.software.institute.kathb.springbootdemo.film.Film;
import com.software.institute.kathb.springbootdemo.film.FilmRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@Service
public class FilmCategoryService implements IFilmCategoryService{

    private final FilmCategoryRepository filmCategoryRepository;
    private final CategoryRepository categoryRepository;
    private final FilmRepository filmRepository;

    public FilmCategoryService(FilmCategoryRepository filmCategoryRepository,
                               CategoryRepository categoryRepository,
                               FilmRepository filmRepository)
    {
        this.filmCategoryRepository = filmCategoryRepository;
        this.categoryRepository = categoryRepository;
        this.filmRepository = filmRepository;
    }

    public void createFilmCategories(Integer filmId, Set<Integer> categoryIds)
    {
        Film film = filmRepository
                .findById(filmId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No film exists with that id"));
        for (Integer categoryId : categoryIds)
        {
            Category category = categoryRepository
                    .findById(categoryId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No category exists with that id"));
            filmCategoryRepository.save(new FilmCategory(film, category));
        }
    }

    public void updateFilmCategories(Integer filmId, Set<Integer> categoryIds)
    {
        deleteFilmCategories(filmId);
        createFilmCategories(filmId, categoryIds);
    }

    public void deleteFilmCategories(Integer filmId)
    {
        filmCategoryRepository.deleteByFilmFilmId(filmId);
    }
}
