package com.example.homework140922.service;

import com.example.homework140922.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyService {

    @Autowired
    MyRepository myRepository;

    public List<String> get(String name){
        System.out.println(name);
        return Optional.of(myRepository.get(name)).orElseThrow(RuntimeException::new);
    }
}
