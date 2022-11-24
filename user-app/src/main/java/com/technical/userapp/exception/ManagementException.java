package com.technical.userapp.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * This class is a custom exception class that extends the AbstractException class
 */
public class ManagementException extends AbstractException{

    private static final HttpStatus DEFAULT_STATUS = HttpStatus.METHOD_NOT_ALLOWED;
    private static final String ERROR_INVALID = "Current data is invalid : ";
    private List<String> reasons;

    public ManagementException(String message, List<String> reasons) {
        super(DEFAULT_STATUS, ERROR_INVALID+message);
        this.reasons = reasons;
    }

}
