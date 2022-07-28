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
    private int actorId;

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

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}