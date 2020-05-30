package com.epam.randomWalk.walk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class walkDto {
    private long walk;
    private static final Logger log = LoggerFactory.getLogger(walkDto.class);

    public walkDto() {
        log.info("WalkDTO object has created");
    }

    public void setWalk(long walk) {
        log.info("Setting walk count");
        this.walk = walk;
    }

    public long getWalk() {
        log.info("Getting walk count");
        return walk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        walkDto walkDto = (walkDto) o;
        return walk == walkDto.walk;
    }

    @Override
    public int hashCode() {
        return Objects.hash(walk);
    }
}
