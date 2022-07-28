package com.software.institute.kathb.springbootdemo.film;

import com.software.institute.kathb.springbootdemo.actor.Actor;
import com.software.institute.kathb.springbootdemo.category.Category;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="film")
public class Film {
    @Id
    @Column(name="film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;

    private String title;
    private String description;
    private String release_year;
    private int language_id;
    private Integer original_language_id;
    private int rental_duration;
    private double rental_rate;
    private Integer length;
    private double replacement_cost;
    private String rating;
    private String special_features;
    private String last_update;

    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> filmCategories;

    @ManyToMany
    @JoinTable(
            name= "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> filmActors;

    public Film(String title, int language_id, int rental_duration, double rental_rate, double replacement_cost, String last_update)
    {
        this.title = title;
        this.language_id = language_id;
        this.rental_duration = rental_duration;
        this.rental_rate = rental_rate;
        this.replacement_cost = replacement_cost;
        this.last_update = last_update;
    }

    public Film() {}

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public Integer getOriginal_language_id() {
        return original_language_id;
    }

    public void setOriginal_language_id(Integer original_language_id) {
        this.original_language_id = original_language_id;
    }

    public int getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(int rental_duration) {
        this.rental_duration = rental_duration;
    }

    public double getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(double rental_rate) {
        this.rental_rate = rental_rate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public double getReplacement_cost() {
        return replacement_cost;
    }

    public void setReplacement_cost(double replacement_cost) {
        this.replacement_cost = replacement_cost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecial_features() {
        return special_features;
    }

    public void setSpecial_features(String special_features) {
        this.special_features = special_features;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public Set<Category> getFilmCategories() {
        return filmCategories;
    }

    public void setFilmCategories(Set<Category> filmCategories) {
        this.filmCategories = filmCategories;
    }

    public Set<Actor> getFilmActors() {
        return filmActors;
    }

    public void setFilmActors(Set<Actor> filmActors) {
        this.filmActors = filmActors;
    }
}
