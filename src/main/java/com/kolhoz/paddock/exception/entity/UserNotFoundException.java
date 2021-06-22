package com.kolhoz.paddock.exception.entity;

import com.kolhoz.paddock.exception.GeneralException;

public class UserNotFoundException extends GeneralException {

    public UserNotFoundException(String message) {
        super(message);
    }

}
