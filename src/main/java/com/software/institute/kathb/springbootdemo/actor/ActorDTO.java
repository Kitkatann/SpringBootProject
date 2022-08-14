package com.software.institute.kathb.springbootdemo.actor;


import java.util.Optional;

public class ActorDTO {

    private Integer actorId;
    private String firstName;
    private String lastName;
    private String lastUpdate;

    public Optional<Integer> getActorId() {
        return Optional.ofNullable(actorId);
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public Optional<String> getFirstName() {
        return Optional.ofNullable(firstName);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Optional<String> getLastName() {
        return Optional.ofNullable(lastName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Optional<String> getLastUpdate() {
        return Optional.ofNullable(lastUpdate);
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
