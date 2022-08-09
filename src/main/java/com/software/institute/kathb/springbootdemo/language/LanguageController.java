package com.software.institute.kathb.springbootdemo.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    private final LanguageRepository languageRepository;

    public LanguageController(LanguageRepository languageRepository)
    {
        this.languageRepository = languageRepository;
    }

    @GetMapping
    public @ResponseBody
    Iterable<Language> getAll()
    {
        return languageRepository.findAll();
    }

    @GetMapping(params = {"name"})
    public @ResponseBody
    Optional<Language> getByName(String name)
    {
        return languageRepository.findByName(name);
    }


}
