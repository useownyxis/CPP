package com.epam.randomWalk.controller;


import com.epam.randomWalk.random.randomService;
import com.epam.randomWalk.response.response;
import com.epam.randomWalk.walk.walkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomWalkController {

    @Autowired
    private randomService randomGenerator;

    @GetMapping("/walk")
    public response randomWalkGeneration (@RequestParam(value = "walkCount") long walkCount) {
        walkDto walks = new walkDto(walkCount);
        randomGenerator = new randomService();
        response response = new response();
        response.setResult(randomGenerator.generate(walks));
        return response;
    }
}