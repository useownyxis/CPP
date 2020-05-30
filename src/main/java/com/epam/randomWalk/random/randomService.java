package com.epam.randomWalk.random;

import com.epam.randomWalk.walk.walkDto;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service("randomService")
public class randomService {
    Random rand;

    public randomService() {
        rand = new Random();
    }

    public long generate(walkDto walks) {
        return rand.nextInt((int) (walks.getWalks()+1));
    }

}
