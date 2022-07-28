package com.software.institute.kathb.springbootdemo.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping()
    public @ResponseBody
    Iterable<Category>getAllCategories()
    {
        return categoryRepository.findAll();
    }
}
