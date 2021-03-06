package com.backend_reserved.backend_reserved.exceptions;

import com.backend_reserved.backend_reserved.controllers.ErrorDto;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class ExistingLocatorError extends BookingExceptions{
    private static final long serialVersionUID = 1L;

    public ExistingLocatorError(String code, String message) {
        super(code, HttpStatus.CREATED.value(), message);
    }

    public ExistingLocatorError(String code, String message, ErrorDto data ) {
        super(code, HttpStatus.CREATED.value(), message, Arrays.asList(data));
    }
}
