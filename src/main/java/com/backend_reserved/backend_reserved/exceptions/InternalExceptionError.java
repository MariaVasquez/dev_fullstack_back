package com.backend_reserved.backend_reserved.exceptions;

import com.backend_reserved.backend_reserved.controllers.ErrorDto;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class InternalExceptionError extends BookingExceptions{
    private static final long serialVersionUID = 1L;
    
    public InternalExceptionError(String code, String message) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public InternalExceptionError(String code, String message, ErrorDto data ) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(data));
    }
}
