package com.validationofdb.dbapivalidation.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class errorDTO {

    private String message;    // Error message
    private int statusCode;    // HTTP Status Code (e.g., 400, 401)
    private String errorType;  // Type of error (e.g., "InvalidCredentialsException")
    private String details;    // Additional details about the error
    
    public errorDTO(String message, int statusCode, String errorType, String details) {
        this.message = message;
        this.statusCode = statusCode;
        this.errorType = errorType;
        this.details = details;
    }

}
