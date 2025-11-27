package com.javapis.dbapi.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class actor {

    @Id
    private int actor_id;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column
    private Date last_update;

}
