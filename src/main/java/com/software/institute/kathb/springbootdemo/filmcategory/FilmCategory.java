package com.software.institute.kathb.springbootdemo.filmcategory;

import com.software.institute.kathb.springbootdemo.category.Category;
import com.software.institute.kathb.springbootdemo.film.Film;

import javax.persistence.*;

@Entity
public class FilmCategory {

    @EmbeddedId
    FilmCategoryKey id;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id")
    Film film;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    Category category;

    @Column(name="last_update", insertable=false, updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    String lastUpdate;

    public FilmCategory(Film film, Category category)
    {
        this.film = film;
        this.category = category;
        id = new FilmCategoryKey(film.getFilmId(), category.getCategoryId());
    }

    public FilmCategory()
    {

    }

    public FilmCategoryKey getId() {
        return id;
    }

    public void setId(FilmCategoryKey id) {
        this.id = id;
    }
}
