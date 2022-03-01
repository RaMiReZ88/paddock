package com.example.paddock.exception.request;

import com.example.paddock.exception.GeneralException;

public class BadRequestException extends GeneralException {

    public BadRequestException(String message) {
        super(message);
    }

}
