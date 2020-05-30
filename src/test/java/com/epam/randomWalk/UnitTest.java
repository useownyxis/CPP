package com.epam.randomWalk;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import com.epam.randomWalk.exception.api.ApiRequestException;
import com.epam.randomWalk.validation.walkValidator;
import com.epam.randomWalk.walk.walkDto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class UnitTest {

	private walkDto walks = new walkDto(20);
	walkValidator validator = new walkValidator();
	private final int[] testWalks =  new int[]{3, 15, 9875};
	private final int[] walksForValidation = new int[]{150, 228, -456, 78, -9999};
	private final long[] overflowNumbers = new long[]{15684987777L, 879876587774L,
													12412157875161L, 6676387949484L, 777777777777L};


	@Test
	public void creationTest() {
		Throwable thrown = catchThrowable(() -> {
			Arrays.stream(testWalks).forEach(v -> {
				walks = new walkDto(v);
			});
		});
	}

	@Test
	public void validationTest() throws ApiRequestException {
		Throwable thrown = catchThrowable(() -> {
			Arrays.stream(walksForValidation).forEach(v -> {
				walks = new walkDto(v);
				validator.validate(walks);
			});
		});
		assertThat(thrown).isInstanceOf(ApiRequestException.class);
		assertThat(thrown.getMessage()).isNotBlank();
	}


	@Test
	public void overflowTest() throws InternalError {
		Throwable thrown = catchThrowable(() -> {
			Arrays.stream(overflowNumbers).forEach(v -> {
				walks = new walkDto(v);
				validator.validate(walks);
			});
		});
		assertThat(thrown).isInstanceOf(InternalError.class);
		assertThat(thrown.getMessage()).isNotBlank();
	}


}