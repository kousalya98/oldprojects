package com.javapis.dbapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javapis.dbapi.Repo.actorrepo;
import com.javapis.dbapi.entity.actor;

@RestController
public class ActorController {

    private actorrepo repo;

    @Autowired
    private ActorController(actorrepo repo) {
        this.repo = repo;
    }

    @GetMapping("/actors")

    public List<actor> getAllActors() {
        try {
            List<actor> actors = repo.findAll();
            return actors;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @GetMapping("/actors/{id}")
    public actor getactordetails(@PathVariable int id) {
        actor actor = repo.findById(id).get();
        return actor;
    }

    @PostMapping("/actor/newactor")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createActor(@RequestBody actor actor) {
        //TODO: process POST request
        repo.save(actor);
    }

    @PutMapping("/actor/update/{id}")
    public actor updateactor(@PathVariable int id) {
        actor a = repo.findById(id).get();
        a.setFirst_name("Kousi");
        a.setLast_name("Srinu");
        repo.save(a);
        return a;
    }

    @DeleteMapping("/actor/delete/{id}")
    public void deleteactor(@PathVariable int id) {
        actor d = repo.findById(id).get();
        repo.delete(d);
    }

}
