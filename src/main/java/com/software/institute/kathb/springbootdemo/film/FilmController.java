package com.software.institute.kathb.springbootdemo.film;


import com.software.institute.kathb.springbootdemo.filmactor.IFilmActorService;
import com.software.institute.kathb.springbootdemo.filmcategory.IFilmCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private IFilmService filmService;
    @Autowired
    private IFilmActorService filmActorService;
    @Autowired
    private IFilmCategoryService filmCategoryService;
    @Autowired
    private ModelMapper modelMapper;

    public FilmController(IFilmService filmService,
                          IFilmActorService filmActorService,
                          IFilmCategoryService filmCategoryService)
    {
        this.filmService = filmService;
        this.filmActorService = filmActorService;
        this.filmCategoryService = filmCategoryService;
    }

    @GetMapping("/{filmId}")
    public @ResponseBody
    Film getFilmById(@PathVariable Integer filmId)
    {
        return filmService.getFilmById(filmId);
    }

    @GetMapping(params = {"title"})
    public @ResponseBody
    List<FilmDTO> getFilmsByTitle(@RequestParam(name = "title", required = false) String title)
    {
        return filmService.getFilmsByTitle(title)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @GetMapping(params = {"categoryId"})
    public @ResponseBody
    List<FilmDTO> getFilmsByCategory(@RequestParam(name = "categoryId") Integer categoryId)
    {
        return filmService.getFilmsByCategory(categoryId)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @GetMapping(params = {"languageId"})
    public @ResponseBody
    List<FilmDTO> getFilmsByLanguage(@RequestParam(name = "languageId") Integer languageId)
    {
        return filmService.getFilmsByLanguage(languageId)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @GetMapping(params = {"actorId"})
    public @ResponseBody
    List<FilmDTO> getFilmsByActor(@RequestParam(name = "actorId") Integer actorId)
    {
        return filmService.getFilmsByActor(actorId)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<FilmDTO> createFilm(@RequestBody FilmDTO filmDTO)
    {
        Integer filmId = filmService.createFilm(filmDTO);
        Film film = filmService.getFilmById(filmId);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDTO(film));
    }

    @PatchMapping(params = {"filmId"})
    public @ResponseBody
    ResponseEntity<FilmDTO> updateFilm(@RequestParam Integer filmId, @RequestBody FilmDTO filmDTO)
    {
        filmService.updateFilm(filmId, filmDTO);
        Film film = filmService.getFilmById(filmId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(convertToDTO(film));
    }

    @DeleteMapping(params = {"filmId"})
    public @ResponseBody
    void deleteFilm(@RequestParam Integer filmId)
    {
        filmService.deleteFilm(filmId);
    }

    //Modify film actors
    @PostMapping("/actors")
    public @ResponseBody
    void createFilmActors(@RequestParam(name = "filmId") Integer filmId,
                          @RequestParam(name = "actorIds") Set<Integer> actorIds)
    {
        filmActorService.createFilmActors(filmId, actorIds);
    }

    @Transactional
    @PatchMapping("/actors")
    public @ResponseBody
    void updateFilmActors(@RequestParam(name = "filmId") Integer filmId,
                          @RequestParam(name = "actorIds") Set<Integer> actorIds)
    {
        filmActorService.updateFilmActors(filmId, actorIds);
    }

    @Transactional
    @DeleteMapping("/actors")
    public @ResponseBody
    void deleteFilmActors(@RequestParam(name = "filmId") Integer filmId)
    {
        filmActorService.deleteFilmActors(filmId);
    }

    //Modify film categories
    @PostMapping("/categories")
    public @ResponseBody
    void createFilmCategories(@RequestParam(name = "filmId") Integer filmId,
                          @RequestParam(name = "categoryIds") Set<Integer> categoryIds)
    {
        filmCategoryService.createFilmCategories(filmId, categoryIds);
    }

    @Transactional
    @PatchMapping("/categories")
    public @ResponseBody
    void updateFilmCategories(@RequestParam(name = "filmId") Integer filmId,
                          @RequestParam(name = "categoryIds") Set<Integer> categoryIds)
    {
        filmCategoryService.updateFilmCategories(filmId, categoryIds);
    }

    @Transactional
    @DeleteMapping("/categories")
    public @ResponseBody
    void deleteFilmCategories(@RequestParam(name = "filmId") Integer filmId)
    {
        filmCategoryService.deleteFilmCategories(filmId);
    }

    private FilmDTO convertToDTO(Film film) {
        return modelMapper.map(film, FilmDTO.class);
    }

}
