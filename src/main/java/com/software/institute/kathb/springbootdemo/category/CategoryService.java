package com.software.institute.kathb.springbootdemo.category;

import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    public Iterable<Category> getAllCategories()
    {
        return categoryRepository.findAll();
    }
}
