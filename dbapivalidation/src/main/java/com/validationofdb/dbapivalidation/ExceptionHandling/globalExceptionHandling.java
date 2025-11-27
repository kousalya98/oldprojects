package com.validationofdb.dbapivalidation.ExceptionHandling;

import org.elasticsoftware.elasticactors.ActorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.validationofdb.dbapivalidation.DTO.actorResponseDTO;
import com.validationofdb.dbapivalidation.DTO.errorDTO;

@ControllerAdvice
public class globalExceptionHandling {

    @ExceptionHandler(ActorNotFoundException.class)
     public ResponseEntity<actorResponseDTO> HandleActorNotFoundException(ActorNotFoundException ex){
            errorDTO error=new errorDTO(ex.getMessage(),HttpStatus.NOT_FOUND.value(),"ActorNotFoundException","The actor you are looking for does not exist");
            actorResponseDTO res=new actorResponseDTO(error);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
     }
}
