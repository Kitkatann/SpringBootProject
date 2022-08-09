package com.software.institute.kathb.springbootdemo.film;


import com.software.institute.kathb.springbootdemo.category.Category;
import com.software.institute.kathb.springbootdemo.category.CategoryRepository;
import com.software.institute.kathb.springbootdemo.language.Language;
import com.software.institute.kathb.springbootdemo.language.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@RestController
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private final FilmRepository filmRepository;

    @Autowired
    private final LanguageRepository languageRepository;

    @Autowired
    private final CategoryRepository categoryRepository;

    public FilmController(FilmRepository filmRepository, LanguageRepository languageRepository, CategoryRepository categoryRepository)
    {
        this.filmRepository = filmRepository;
        this.languageRepository = languageRepository;
        this.categoryRepository = categoryRepository;
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
        // make sure languageId is valid as it cannot be allowed to be null
        Language language = languageRepository
                .findByName(languageName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No language exists with that name."));
        Integer languageId = language.getLanguageId();

        // original language is allowed to be null
        Integer originalLanguageId = null;
        if (originalLanguageName != null)
        {
            Language originalLanguage = languageRepository
                    .findByName(originalLanguageName)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No language exists with that name."));
            originalLanguageId = originalLanguage.getLanguageId();
        }
        Film film = new Film(title, description, releaseYear, languageId, originalLanguageId, rentalDuration, rentalRate,
                length, replacementCost, rating, specialFeatures, lastUpdate);
        filmRepository.save(film);
        return "saved";
    }

    @PatchMapping(params = {"filmId", "categoryNames"})
    public @ResponseBody String updateFilmCategories(@RequestParam int filmId, @RequestParam Set<String> categoryNames)
    {
        Film film = filmRepository
                .findById(filmId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No film exists with that id."));
        Set<Category> categories = film.getFilmCategories();
        for (String categoryName : categoryNames)
        {
            Category category = categoryRepository.findByName(categoryName);
            if (category != null && !film.getFilmCategories().contains(category))
            {
                categories.add(category);
            }
        }
        film.setFilmCategories(categories);
        filmRepository.save(film);
        return "saved";
    }

    @PatchMapping
    public @ResponseBody String updateFilmDetails(@RequestParam(name = "filmId") Integer filmId,
                                                  @RequestParam(name = "title") String title,
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
        Film film = filmRepository
                .findById(filmId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No film exists with that id."));
        film.setTitle(title);
        film.setDescription(description);
        film.setReleaseYear(releaseYear);

        // make sure languageId is valid as it cannot be allowed to be null
        Language language = languageRepository
                .findByName(languageName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No language exists with that name."));
        film.setLanguageId(language.getLanguageId());

        // original language is allowed to be null
        Integer originalLanguageId = null;
        if (originalLanguageName != null)
        {
            Language originalLanguage = languageRepository
                    .findByName(originalLanguageName)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No language exists with that name."));
            originalLanguageId = originalLanguage.getLanguageId();
        }
        film.setOriginalLanguageId(originalLanguageId);

        film.setRentalDuration(rentalDuration);
        film.setRentalRate(rentalRate);
        film.setLength(length);
        film.setReplacementCost(replacementCost);
        film.setRating(rating);
        film.setSpecialFeatures(specialFeatures);
        film.setLastUpdate(lastUpdate);
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
