package com.software.institute.kathb.springbootdemo;

import javax.persistence.*;

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
    private int original_language_id;
    private int rental_duration;
    private double rental_rate;
    private int length;
}
