package com.software.institute.kathb.springbootdemo.film;

import com.software.institute.kathb.springbootdemo.filmactor.FilmActor;
import com.software.institute.kathb.springbootdemo.category.Category;
import com.software.institute.kathb.springbootdemo.language.Language;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name= "film")
public class Film {
    @Id
    @Column(name="film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmId;

    private String title;
    private String description;

    @Column(name="release_year")
    private String releaseYear;

    @Column(name="language_id")
    private Integer languageId;

    @ManyToOne
    @JoinColumn(name = "language_id", insertable = false, updatable = false)
    private Language filmLanguage;

    @Column(name="original_language_id")
    private Integer originalLanguageId;

    @ManyToOne
    @JoinColumn(name = "original_language_id", insertable = false, updatable = false)
    private Language originalFilmLanguage;

    @Column(name="rental_duration")
    private int rentalDuration;

    @Column(name="rental_rate")
    private double rentalRate;
    private Integer length;

    @Column(name="replacement_cost")
    private double replacementCost;
    private String rating;

    @Column(name="special_features")
    private String specialFeatures;

    @Column(name="last_update", insertable=false, updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String lastUpdate;

    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> filmCategories;

    @OneToMany(mappedBy = "film")
    private Set<FilmActor> filmActors;


    public Film(String title, String description, String releaseYear, Integer languageId, Integer originalLanguageId,
                int rentalDuration, double rentalRate, Integer length, double replacementCost, String rating,
                String specialFeatures, String lastUpdate)
    {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.languageId = languageId;
        this.originalLanguageId = originalLanguageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.specialFeatures = specialFeatures;
        this.lastUpdate = lastUpdate;
    }

    public Film(String title, String description, Integer languageId, int rentalDuration, double rentalRate,
                double replacementCost)
    {
        this.title = title;
        this.description = description;
        this.languageId = languageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.replacementCost = replacementCost;
    }

    public Film() {}

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
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

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Language getFilmLanguage() {
        return filmLanguage;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Language getOriginalFilmLanguage() {
        return originalFilmLanguage;
    }

    public void setOriginalLanguageId(Integer originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(double replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Category> getFilmCategories() {
        return filmCategories;
    }

    public void setFilmCategories(Set<Category> filmCategories) {
        this.filmCategories = filmCategories;
    }

}
