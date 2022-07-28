package com.software.institute.kathb.springbootdemo.actor;

import com.software.institute.kathb.springbootdemo.film.Film;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="actor")
public class Actor {

    @Id
    @Column(name="actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actor_id;

    //Attributes
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @ManyToMany(mappedBy = "filmActors")
    Set<Film> actorFilms;

    public Actor(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    //Empty Constructor
    public Actor() {}

    //Getter and Setters

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = lastName;
    }
}