package com.software.institute.kathb.springbootdemo.actor;

import org.springframework.data.repository.CrudRepository;


public interface ActorRepository extends CrudRepository<Actor,Integer> {
    Iterable<Actor> findByFirstNameAndLastName(String lastName, String firstName);
}
