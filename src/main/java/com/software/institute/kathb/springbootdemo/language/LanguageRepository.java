package com.software.institute.kathb.springbootdemo.language;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LanguageRepository extends CrudRepository<Language, Integer>{

    Optional<Language> findByName(String name);

}
