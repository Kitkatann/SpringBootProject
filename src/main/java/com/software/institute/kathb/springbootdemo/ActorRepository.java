package com.software.institute.kathb.springbootdemo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActorRepository extends CrudRepository<Actor,Integer> {
    @Query(value = "SELECT * FROM actor WHERE first_name = ?1 AND last_name = ?2", nativeQuery = true)
    Actor findByLastnameAndFirstname(String firstname, String lastname);
}
