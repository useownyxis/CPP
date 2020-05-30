package com.epam.randomWalk.validation;


import com.epam.randomWalk.exception.api.ApiRequestException;
import com.epam.randomWalk.walk.walkDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class walkValidator {
    private static final Logger log = LoggerFactory.getLogger(walkDto.class);

    public walkValidator() {}

    public void validate(walkDto o) {
        log.info("Validate...");
        if (o.getWalk() < 0) {
            log.error("Wrong number of walks!");
            throw new ApiRequestException("Number of walks must be > 0");
        }
        if (o.getWalk() > Integer.MAX_VALUE) {
            log.error("Wrong number size");
            throw new InternalError("Integer Overflow Error");
        }
	}
	public void validate(Long walk) {
        log.info("Validate...");
        if (walk < 0) {
            log.error("Wrong number of walks!");
            throw new ApiRequestException("Number of walks must be > 0");
        }
        if (walk > Integer.MAX_VALUE) {
            log.error("Wrong number size");
            throw new InternalError("Integer Overflow Error");
        }
	}

}
