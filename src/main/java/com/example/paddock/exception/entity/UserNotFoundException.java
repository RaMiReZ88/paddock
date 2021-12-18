package com.example.paddock.exception.entity;

import com.example.paddock.exception.GeneralException;

public class UserNotFoundException extends GeneralException {

    public UserNotFoundException(String message) {
        super(message);
    }

}
