package com.validationofdb.dbapivalidation.DTO;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Component;

import com.validationofdb.dbapivalidation.entity.actor;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class actorResponseDTO {
  
    private int id;
    private String first_name;
    private String last_Name;
    private LocalDateTime last_update;
    private String message;
    private errorDTO error;
    public actorResponseDTO(errorDTO error2) {
     
    }
    public actorResponseDTO() {
        //TODO Auto-generated constructor stub
    }
}
