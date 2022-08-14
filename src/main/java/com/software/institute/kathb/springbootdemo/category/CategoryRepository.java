package com.software.institute.kathb.springbootdemo.category;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Optional<Category> findByName(String name);
}
