package com.validationofdb.dbapivalidation.mapping;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.validationofdb.dbapivalidation.DTO.actorResponseDTO;
import com.validationofdb.dbapivalidation.entity.actor;
@Component
public class actorToActorresponseDTO {

    public actorResponseDTO convertactorResponseDTO(actor Actor){
         actorResponseDTO res=new actorResponseDTO();
         res.setId(Actor.getActor_id());
         res.setFirst_name(Actor.getFirst_name());
         res.setLast_Name(Actor.getLast_name());
        res.setLast_update(LocalDateTime.now());
        return res;
    }

}
