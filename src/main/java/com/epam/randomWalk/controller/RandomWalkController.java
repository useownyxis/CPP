package com.epam.randomWalk.controller;


import com.epam.randomWalk.cache.cacheService;
import com.epam.randomWalk.random.randomService;
import com.epam.randomWalk.requestCounter.requestCounter;
import com.epam.randomWalk.response.response;
import com.epam.randomWalk.validation.walkValidator;
import com.epam.randomWalk.walk.multipleWalkDto;
import com.epam.randomWalk.walk.walkDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.Semaphore;


@RestController
public class RandomWalkController {

    private static final Logger log = LoggerFactory.getLogger(RandomWalkController.class);

    @Autowired
    private randomService randomGenerator;

    @Autowired
    private cacheService cache = new cacheService();

    requestCounter counter = new requestCounter(0, new Semaphore(1));
    walkValidator validator = new walkValidator();

    @GetMapping("/walk")
    public response randomWalkGeneration (@RequestParam(value = "walkCount") long walkCount) {
        this.counter.increaseNumberOfRequests();
        log.info(String.format("GET/ request detected with request param: %s", walkCount));
        walkDto walks = new walkDto();
        walks.setWalk(walkCount);
        validator.validate(walks);
        randomGenerator = new randomService();
        response response = new response();
        if (cache.contains(walks)) {
            response.setResult(randomGenerator.generate(walks));
            Optional<Long> previousResult = cache.getCache().entrySet()
                                .stream()
                                .filter(p -> walks.equals(p.getKey()))
                                .map(p -> {return p.getValue();})
                                .findAny();
            response.setPreviousResult(previousResult.get());
            cache.updateValue(walks, response.getLastResult());
        } else {
            response.setResult(randomGenerator.generate(walks));
            response.setPreviousResult(-1);
            cache.add(walks, response.getLastResult());
        }
        response.setRequests(counter.getCounter());
        return response;
    }


    @PostMapping("/walk")
    public response bulkRandomWalkGeneration(@RequestBody multipleWalkDto walks) {
        randomGenerator = new randomService();
        response response = new response();
        walks.getWalks()
                .stream()
                .forEach(walk -> {
                    validator.validate(walk);
                    response.setResult(randomGenerator.generate(walk));
                    if (cache.contains(walk)) {
                        response.setPreviousResult(cache.getResults(walk));
                        cache.updateValue(walk, response.getLastResult());
                    } else {
                        response.setResult(randomGenerator.generate(walk));
                        response.setPreviousResult(-1);
                        cache.add(walk, response.getLastResult());
                    }
                });
        response.setRequests(walks.getWalks().size());
        return response;
    }

    @GetMapping("/test")
    public multipleWalkDto test () {
        multipleWalkDto r =  new multipleWalkDto();
        ArrayList<walkDto> walks = new ArrayList<>();
        walkDto walks1 = new walkDto();
        walks1.setWalk(15);
        walks.add(walks1);
        r.setWalks(walks);
        return r;
    }

}