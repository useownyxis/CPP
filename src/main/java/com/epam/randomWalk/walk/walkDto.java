package com.epam.randomWalk.walk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class walkDto {
    long walks;
    private static final Logger log = LoggerFactory.getLogger(walkDto.class);

    public walkDto(long walks) {
        log.info("WalkDTO object has created");
        this.walks = walks;
    }

    public void setWalks(long walks) {
        log.info("Setting walk count");
        this.walks = walks;
    }

    public long getWalks() {
        log.info("Getting walk count");
        return walks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        walkDto walkDto = (walkDto) o;
        return walks == walkDto.walks;
    }

    @Override
    public int hashCode() {
        return Objects.hash(walks);
    }
}
