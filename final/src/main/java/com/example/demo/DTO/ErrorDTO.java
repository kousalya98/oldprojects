package com.example.demo.DTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO {
    private String message;    // Error message
    private int statusCode;    // HTTP Status Code (e.g., 400, 401)
    private String errorType;  // Type of error (e.g., "InvalidCredentialsException")
    private String details;    // Additional details about the error
     public ErrorDTO(String message, int statusCode, String errorType, String details) {
         this.message = message;
         this.statusCode = statusCode;
         this.errorType = errorType;
         this.details = details;
    }
}
