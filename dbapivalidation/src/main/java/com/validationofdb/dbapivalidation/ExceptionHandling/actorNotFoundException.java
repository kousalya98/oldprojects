package com.validationofdb.dbapivalidation.ExceptionHandling;

public class actorNotFoundException extends RuntimeException{
    public actorNotFoundException(String message)
    {
        super(message);
    }

}
