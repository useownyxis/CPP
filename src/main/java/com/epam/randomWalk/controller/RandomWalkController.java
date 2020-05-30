package com.epam.randomWalk.controller;


import com.epam.randomWalk.cache.cacheService;
import com.epam.randomWalk.random.randomService;
import com.epam.randomWalk.response.response;
import com.epam.randomWalk.validation.walkValidator;
import com.epam.randomWalk.walk.walkDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Null;

@RestController
public class RandomWalkController {

    private static final Logger log = LoggerFactory.getLogger(RandomWalkController.class);

    @Autowired
    private randomService randomGenerator;

    @Autowired
    private cacheService cache = new cacheService();

    walkValidator validator = new walkValidator();

    @GetMapping("/walk")
    public response randomWalkGeneration (@RequestParam(value = "walkCount") long walkCount) {
        log.info(String.format("GET/ request detected with request param: %s", walkCount));
        walkDto walks = new walkDto(walkCount);
        validator.validate(walks);
        randomGenerator = new randomService();
        response response = new response();
        if (cache.contains(walks)) {
            response.setResult(randomGenerator.generate(walks));
            response.setPreviousResult(cache.getResults(walks));
            cache.updateValue(walks, response.getResult());
        } else {
            response.setResult(randomGenerator.generate(walks));
            response.setPreviousResult(-1);
            cache.add(walks, response.getResult());
        }
        return response;
    }
}