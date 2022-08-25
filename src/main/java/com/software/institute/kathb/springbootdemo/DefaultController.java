package com.software.institute.kathb.springbootdemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
    @GetMapping()
    public @ResponseBody
    HttpStatus get()
    {
        return HttpStatus.OK;
    }
}
