package com.software.institute.kathb.springbootdemo.actor;

import com.software.institute.kathb.springbootdemo.filmactor.FilmActor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="actor")
public class Actor {

    @Id
    @Column(name="actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actorId;

    //Attributes
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Formula("concat(first_name, ' ', last_name)")
    protected String fullName;

    @Column(name="last_update", insertable=false, updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String lastUpdate;

    @OneToMany(mappedBy = "actor")
    private Set<FilmActor> actorFilms;

    public Actor(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public Actor(ActorDTO actorDTO)
    {
        this.updateFromDTO(actorDTO);
    }

    public Actor() {}

    public void updateFromDTO(ActorDTO actorDTO)
    {
        this.firstName = actorDTO.getFirstName().orElse(firstName);
        this.lastName = actorDTO.getLastName().orElse(lastName);
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
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

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}