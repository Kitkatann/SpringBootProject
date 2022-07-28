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
    private String lastUpdate;

    @ManyToMany(mappedBy = "filmCategories")
    private Set<Film> categoryFilms;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String last_update) {
        this.lastUpdate = lastUpdate;
    }

}
