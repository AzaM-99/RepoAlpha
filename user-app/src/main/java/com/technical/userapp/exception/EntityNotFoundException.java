package com.technical.userapp.exception;

import org.springframework.http.HttpStatus;

/**
 * This class is used to throw an exception when an entity is not found in the database
 */
public class EntityNotFoundException extends AbstractException{

    private static final HttpStatus DEFAULT_STATUS = HttpStatus.NOT_FOUND;
    private static final String ERROR_KEY_ENTITY_DOES_NOT_EXIST = "ENTITY DOES NOT EXIST : ";

    public EntityNotFoundException(String entityName, Long id) {
        this(entityName, String.valueOf(id));
    }

    public EntityNotFoundException(String entityName, String id) {
        super(DEFAULT_STATUS, (ERROR_KEY_ENTITY_DOES_NOT_EXIST +" [" +entityName+ "] - "+ id));
    }
}
