package com.software.institute.kathb.springbootdemo.film;

import com.software.institute.kathb.springbootdemo.filmactor.FilmActor;
import com.software.institute.kathb.springbootdemo.filmcategory.FilmCategory;
import com.software.institute.kathb.springbootdemo.language.Language;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name= "film")
public class Film {
    @Id
    @Column(name="film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer filmId;

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
    private Integer rentalDuration;

    @Column(name="rental_rate")
    private Double rentalRate;
    private Integer length;

    @Column(name="replacement_cost")
    private Double replacementCost;
    private String rating;

    @Column(name="special_features")
    private String specialFeatures;

    @Column(name="last_update", insertable=false, updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String lastUpdate;

    @OneToMany(mappedBy = "film")
    private Set<FilmActor> filmActors;

    @OneToMany(mappedBy = "film")
    private Set<FilmCategory> filmCategories;

    public Film() {}

    public Film(FilmDTO filmDTO)
    {
        this.updateFromDTO(filmDTO);
    }

    public void updateFromDTO(FilmDTO filmDTO)
    {
        this.title = filmDTO.getTitle().orElse(title);
        this.description = filmDTO.getDescription().orElse(description);
        this.releaseYear = filmDTO.getReleaseYear().orElse(releaseYear);
        this.languageId = filmDTO.getLanguageId().orElse(languageId);
        this.originalLanguageId = filmDTO.getOriginalLanguageId().orElse(originalLanguageId);
        this.rentalDuration = filmDTO.getRentalDuration().orElse(rentalDuration);
        this.rentalRate = filmDTO.getRentalRate().orElse(rentalRate);
        this.length = filmDTO.getLength().orElse(length);
        this.replacementCost = filmDTO.getReplacementCost().orElse(replacementCost);
        this.rating = filmDTO.getRating().orElse(rating);
        this.specialFeatures = filmDTO.getSpecialFeatures().orElse(specialFeatures);
    }


    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
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

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public Double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(Double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(Double replacementCost) {
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

}
