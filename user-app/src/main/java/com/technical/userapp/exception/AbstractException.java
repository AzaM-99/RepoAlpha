package com.technical.userapp.exception;

import org.springframework.http.HttpStatus;

/**
 * This class is an abstract class that extends RuntimeException and has a constructor that takes in a
 * HttpStatus and a String
 */
public abstract class AbstractException extends RuntimeException{
    private HttpStatus status;

    public AbstractException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

}
