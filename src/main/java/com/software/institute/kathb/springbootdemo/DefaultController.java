package com.software.institute.kathb.springbootdemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {


    @GetMapping
    public ResponseEntity<Void> getRoot(){
        return ResponseEntity.status(200).build();
    }

}
