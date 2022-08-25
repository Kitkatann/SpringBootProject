package com.software.institute.kathb.springbootdemo.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired private ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService)
    {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Category> getAllCategories()
    {
        return categoryService.getAllCategories();
    }

    @GetMapping(params = {"filmId"})
    public @ResponseBody
    Iterable<Category> getCategoriesByFilm(@RequestParam(name = "filmId") Integer filmId)
    {
        return categoryService.getCategoriesByFilm(filmId);
    }
}
