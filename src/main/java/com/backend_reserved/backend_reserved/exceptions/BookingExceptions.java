package com.backend_reserved.backend_reserved.exceptions;

import com.backend_reserved.backend_reserved.controllers.ErrorDto;

import java.util.ArrayList;
import java.util.List;

public class BookingExceptions extends Exception{

    private static final long serialVersionUID = 1L;
    private final String code;
    private final int responsecode;
    private final List<ErrorDto> errorDtoList = new ArrayList<>();

    public BookingExceptions(String code, int responsecode, String message) {
        super(message);
        this.code = code;
        this.responsecode = responsecode;
    }

    public BookingExceptions(String code, int responsecode, String message, List<ErrorDto> errorDtoList ) {
        super(message);
        this.code = code;
        this.responsecode = responsecode;
        this.errorDtoList.addAll(errorDtoList);
    }


    public String getCode() {
        return code;
    }

    public int getResponsecode() {
        return responsecode;
    }

    public List<ErrorDto> getErrorDtoList() {
        return errorDtoList;
    }


}
