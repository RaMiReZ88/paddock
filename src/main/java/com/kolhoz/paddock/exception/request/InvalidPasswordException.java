package com.kolhoz.paddock.exception.request;

import com.kolhoz.paddock.exception.GeneralException;

public class InvalidPasswordException extends GeneralException {

    public InvalidPasswordException(String message) {
        super(message);
    }
}
