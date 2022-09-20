package com.example.homework140922.controller;

import com.example.homework140922.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class MyController {

    @Autowired
    MyService myService;

    @GetMapping("/{name}")
    public List<?> get(@PathVariable String name){
        return myService.get(name);
    }
}
