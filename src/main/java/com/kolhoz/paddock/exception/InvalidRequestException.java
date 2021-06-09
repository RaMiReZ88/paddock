package com.kolhoz.paddock.exception;

public abstract class InvalidRequestException extends Exception{

    public InvalidRequestException(String message) {
        super(message);
    }

}
