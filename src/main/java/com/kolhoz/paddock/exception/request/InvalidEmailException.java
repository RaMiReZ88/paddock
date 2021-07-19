package com.kolhoz.paddock.exception.request;

import com.kolhoz.paddock.exception.GeneralException;

public class InvalidEmailException extends GeneralException {

    public InvalidEmailException(String message) {
        super(message);
    }
}
