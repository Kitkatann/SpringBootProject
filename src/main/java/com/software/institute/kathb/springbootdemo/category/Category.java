package com.software.institute.kathb.springbootdemo.category;

import com.software.institute.kathb.springbootdemo.film.Film;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="category")
public class Category {
    @Id
    @Column(name="category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String name;
    private String last_update;

    @ManyToMany(mappedBy = "filmCategories")
    private Set<Film> categoryFilms;

    public int getCategory_id() {
        return categoryId;
    }

    public void setCategory_id(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

}
