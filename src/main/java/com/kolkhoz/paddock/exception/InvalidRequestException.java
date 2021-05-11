package com.kolkhoz.paddock.exception;

public abstract class InvalidRequestException extends Exception{

    public InvalidRequestException(String message) {
        super(message);
    }

}
