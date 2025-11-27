package com.validationofdb.dbapivalidation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.validationofdb.dbapivalidation.DTO.actorResponseDTO;
import com.validationofdb.dbapivalidation.DTO.actorrequestDTO;
import com.validationofdb.dbapivalidation.ExceptionHandling.actorNotFoundException;
import com.validationofdb.dbapivalidation.ExceptionHandling.genralException;
import com.validationofdb.dbapivalidation.entity.actor;
import com.validationofdb.dbapivalidation.mapping.actorToActorresponseDTO;
import com.validationofdb.dbapivalidation.mapping.actorrequestmapping;
import com.validationofdb.dbapivalidation.repo.actorrepo;

@Service
public class actorservice {

    private actorrepo actorRepo;
    private actorToActorresponseDTO actorToActorresponseDTOtt;
    private actorrequestmapping Actorrequestmapping;

    
   @Autowired
    public actorservice(actorrepo actorRepo, actorToActorresponseDTO actorToActorresponseDTOtt,actorrequestmapping Actorrequestmapping) {
        this.actorRepo = actorRepo;
        this.actorToActorresponseDTOtt=actorToActorresponseDTOtt;
        this.Actorrequestmapping=Actorrequestmapping;
       
    }
    public actorResponseDTO getSingleActorservice(int id){
        try
        {
            actorResponseDTO dto=new actorResponseDTO();
            Optional<actor> res= actorRepo.findById(id);
     
            if(res.isPresent()){
                dto=actorToActorresponseDTOtt.convertactorResponseDTO(res.get());  
            }
            else{
                throw new actorNotFoundException("The Actor ID not found");
            }
            return dto; 
        }
        catch(Exception ex){
            throw new genralException("Some System error"+ex.getMessage());
        }  
    }
    public List<actorResponseDTO> getAllActors() {
              List<actor> res=actorRepo.findAll();
              List<actorResponseDTO> list=new ArrayList<>();
        actorResponseDTO dto=new actorResponseDTO();
    for (actor Actor : res) {
        dto=actorToActorresponseDTOtt.convertactorResponseDTO(Actor);
          list.add(dto);
    }
        return list;
    }
    public actorResponseDTO addActor(actorrequestDTO actorrequestdto) {
        
       actor res = actorRepo.save(Actorrequestmapping.convertrequestDTOtoactor(actorrequestdto));
             return actorToActorresponseDTOtt.convertactorResponseDTO(res);
    }
    public actorResponseDTO UpdateActor(int id, actorrequestDTO actorrequestdto) {
        Optional<actor> existsactor =actorRepo.findById(id);
        actorResponseDTO dto=new actorResponseDTO();
        if(existsactor.isPresent()){
         actor actornew= Actorrequestmapping.convertrequestDTOtoactor(actorrequestdto);
         actornew.setActor_id(id);
         return actorToActorresponseDTOtt.convertactorResponseDTO(actorRepo.save(actornew));
        }         
        return dto; 
        }
    public actorResponseDTO patchactor(int id, actorrequestDTO actorrequestdto) {

        Optional<actor> existingdata=actorRepo.findById(id);
        actor Actor=existingdata.get();
        if(existingdata.isPresent()){
           if(actorrequestdto.getFirst_name() !=null)
            Actor.setFirst_name(actorrequestdto.getFirst_name());

           if(actorrequestdto.getLast_Name() != null)
           Actor.setLast_name(actorrequestdto.getLast_Name());
        }
        return actorToActorresponseDTOtt.convertactorResponseDTO(actorRepo.save(Actor));

    }
    public actorResponseDTO deleteactor(int id) {
      Optional<actor> exisitactor=actorRepo.findById(id); 
      actor Actor=exisitactor.get();
      actorResponseDTO dto=actorToActorresponseDTOtt.convertactorResponseDTO(Actor);
      actorRepo.deleteById(id);
      return dto;
      
    }
        
    }




