package com.software.institute.kathb.springbootdemo.film;

import com.software.institute.kathb.springbootdemo.language.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private final FilmRepository filmRepository;

    @Autowired
    private final LanguageRepository languageRepository;

    public FilmController(FilmRepository filmRepository, LanguageRepository languageRepository)
    {
        this.filmRepository = filmRepository;
        this.languageRepository = languageRepository;
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

    @GetMapping(params = {"language"})
    public @ResponseBody
    Iterable<Film> getFilmsByLanguage(@RequestParam(name = "language") String language)
    {
        if (language != null)
        {
            return filmRepository.findByFilmLanguageName(language);
        }
        return filmRepository.findAll();
    }
    @PostMapping
    public @ResponseBody
    String addNewFilm(@RequestParam(name = "title") String title,
                      @RequestParam(name = "description", required = false) String description,
                      @RequestParam(name = "releaseYear", required = false) String releaseYear,
                      @RequestParam(name = "languageName") String languageName,
                      @RequestParam(name = "originalLanguageName", required = false) String originalLanguageName,
                      @RequestParam(name = "rentalDuration") int rentalDuration,
                      @RequestParam(name = "rentalRate") double rentalRate,
                      @RequestParam(name = "length", required = false) Integer length,
                      @RequestParam(name = "replacementCost") double replacementCost,
                      @RequestParam(name = "rating", required = false) String rating,
                      @RequestParam(name = "specialFeatures", required = false) String specialFeatures,
                      @RequestParam(name = "lastUpdate", required = false) String lastUpdate)
    {
        Integer languageId = languageRepository.findByName(languageName).getLanguageId();
        Integer originalLanguageId = null;
        if (originalLanguageName != null)
        {
            originalLanguageId = languageRepository.findByName(originalLanguageName).getLanguageId();
        }
        Film film = new Film(title, description, releaseYear, languageId, originalLanguageId, rentalDuration, rentalRate,
                length, replacementCost, rating, specialFeatures, lastUpdate);
        filmRepository.save(film);
        return "saved";
    }

    @DeleteMapping(params = {"filmId"})
    public @ResponseBody
    void deleteFilmById(@RequestParam int filmId)
    {
        filmRepository.deleteById(filmId);
    }

}
