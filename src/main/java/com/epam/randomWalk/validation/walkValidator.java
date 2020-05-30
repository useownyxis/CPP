package com.epam.randomWalk.validation;


import com.epam.randomWalk.exception.api.ApiRequestException;
import com.epam.randomWalk.walk.walkDto;
import org.springframework.stereotype.Component;

@Component
public class walkValidator {

    public walkValidator() {}

    public void validate(walkDto o) {
        if (o.getWalks() < 0) {
            throw new ApiRequestException("Number of walks must be > 0");
        }
        if (o.getWalks() > Integer.MAX_VALUE) {
            throw new InternalError("Integer Overflow Error");
        }
	}

}
