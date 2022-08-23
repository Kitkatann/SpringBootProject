package com.software.institute.kathb.springbootdemo.category;

import com.software.institute.kathb.springbootdemo.filmcategory.FilmCategory;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="category")
public class Category {
    @Id
    @Column(name="category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String name;
    private String lastUpdate;

    @OneToMany(mappedBy = "category")
    private Set<FilmCategory> categoryFilms;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
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

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
