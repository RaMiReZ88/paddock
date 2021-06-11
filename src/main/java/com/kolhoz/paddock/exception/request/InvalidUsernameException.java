package com.kolhoz.paddock.exception.request;

import com.kolhoz.paddock.exception.GeneralException;

public class InvalidUsernameException extends GeneralException {

    public InvalidUsernameException(String message) {
        super(message);
    }
}
