package com.software.institute.kathb.springbootdemo.category;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Category findByName(String name);
}
