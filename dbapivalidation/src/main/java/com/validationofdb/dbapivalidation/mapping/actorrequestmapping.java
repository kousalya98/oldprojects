package com.validationofdb.dbapivalidation.mapping;

import org.springframework.stereotype.Component;

import com.validationofdb.dbapivalidation.DTO.actorrequestDTO;
import com.validationofdb.dbapivalidation.entity.actor;

@Component
public class actorrequestmapping {

    public actor convertrequestDTOtoactor(actorrequestDTO actorrequestdto){/*coverting requestdto 
        to entity type which is type of actor.*/
        actor res=new actor();
        res.setFirst_name(actorrequestdto.getFirst_name());
        res.setLast_name(actorrequestdto.getLast_Name());
        return res;
    }

}
