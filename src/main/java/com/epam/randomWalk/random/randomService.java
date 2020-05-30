package com.epam.randomWalk.random;

import com.epam.randomWalk.walk.walkDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service("randomService")
public class randomService {
    private static final Logger log = LoggerFactory.getLogger(walkDto.class);
    Random rand;

    public randomService() {
        rand = new Random();
    }

    public long generate(walkDto walks) {
        log.info(String.format("Generate random number in 0<num<%s", walks.getWalks()));
        return rand.nextInt((int) (walks.getWalks()+1));
    }

}
