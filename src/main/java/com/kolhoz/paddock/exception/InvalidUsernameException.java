package com.kolhoz.paddock.exception;

public class InvalidUsernameException extends InvalidRequestException {

    public InvalidUsernameException(String message) {
        super(message);
    }
}
