package com.software.institute.kathb.springbootdemo.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private final FilmRepository filmRepository;

    public FilmController(FilmRepository filmRepository)
    {
        this.filmRepository = filmRepository;
    }

    @GetMapping(params = {"title"})
    public @ResponseBody
    Iterable<Film> getFilmByTitle(@RequestParam(name = "title", required = false) String title)
    {
        if (title != null)
        {
            return filmRepository.findByTitleContainingOrderByTitle(title);
        }
        return filmRepository.findAll();
    }

    @GetMapping(params = {"categoryName"})
    public @ResponseBody
    Iterable<Film> getFilmByCategory(@RequestParam(name = "categoryName", required = false) String categoryName)
    {
        if (categoryName != null)
        {
            return filmRepository.findByFilmCategoriesName(categoryName);
        }
        return filmRepository.findAll();
    }

    @GetMapping(params = {"title", "categoryName"})
    public @ResponseBody
    Iterable<Film> getFilmsByTitleAndCategory(@RequestParam(name = "title", required = false) String title,
                            @RequestParam(name = "categoryName", required = false) String categoryName)
    {
        if (title != null && categoryName != null)
        {
            return filmRepository.findByTitleContainingAndFilmCategoriesNameOrderByTitle(title, categoryName);
        }
        return filmRepository.findAll();
    }

}
