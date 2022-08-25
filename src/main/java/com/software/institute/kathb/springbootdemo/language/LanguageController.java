package com.software.institute.kathb.springbootdemo.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired private ILanguageService languageService;

    public LanguageController(ILanguageService langaugeService)
    {
        this.languageService = langaugeService;
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Language> getAllLanguages()
    {
        return languageService.getAllLanguages();
    }
}
