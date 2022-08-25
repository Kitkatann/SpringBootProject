package com.software.institute.kathb.springbootdemo.language;

import org.springframework.stereotype.Service;

@Service
public class LanguageService implements ILanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository)
    {
        this.languageRepository = languageRepository;
    }

    public Iterable<Language> getAllLanguages()
    {
        return languageRepository.findAll();
    }

}
