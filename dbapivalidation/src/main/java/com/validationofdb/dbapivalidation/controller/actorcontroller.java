package com.validationofdb.dbapivalidation.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.validationofdb.dbapivalidation.DTO.actorResponseDTO;
import com.validationofdb.dbapivalidation.DTO.actorrequestDTO;
import com.validationofdb.dbapivalidation.service.actorservice;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/actors")
public class actorcontroller {
    private actorservice actorService;

    @Autowired
    public actorcontroller( actorservice actorService) {
        this.actorService=actorService;
    }
    @GetMapping("/{id}")
    public actorResponseDTO getSingleActor(@PathVariable int id){

        return actorService.getSingleActorservice(id);

    }
    @GetMapping("/")
    public List<actorResponseDTO> getAllActors(){
        return actorService.getAllActors();
    }
    @PostMapping()//post method clinet will provide data which one need to add in body
    public actorResponseDTO addActor(@RequestBody actorrequestDTO actorrequestdto){
        //so, request body used and request details format have in actorrequestDTO
        return actorService.addActor(actorrequestdto);//returning service method addActor return value.

    }
    @PutMapping("/{id}")
    public actorResponseDTO UpdateActor(@PathVariable int id, @RequestBody actorrequestDTO actorrequestdto) {
        
        return actorService.UpdateActor(id,actorrequestdto);
    }
    @PatchMapping("/{id}")
    public actorResponseDTO patchactor(@PathVariable int id, @RequestBody actorrequestDTO actorrequestdto){
        return actorService.patchactor(id,actorrequestdto);

    }
    @DeleteMapping("/{id}")
    public actorResponseDTO deleteactor(@PathVariable int id){
        return actorService.deleteactor(id);
    }
    
    

    



}
