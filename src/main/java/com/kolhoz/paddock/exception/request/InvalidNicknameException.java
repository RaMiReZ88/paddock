package com.kolhoz.paddock.exception.request;

import com.kolhoz.paddock.exception.GeneralException;

public class InvalidNicknameException extends GeneralException {

    public InvalidNicknameException(String message) {
        super(message);
    }

}
