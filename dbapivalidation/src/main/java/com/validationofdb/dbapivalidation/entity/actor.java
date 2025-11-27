package com.validationofdb.dbapivalidation.entity;




import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class actor {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int actor_id;
    @Column
    private String first_name;
    @Column
    private String last_name;
    
    @Column
    private LocalDateTime last_update;
    
    @PrePersist
    public void setLastUpdate() {
        if (this.last_update == null) {
            this.last_update = LocalDateTime.now(); // Set the current date if it's not provided
        }    
    }

    @PreUpdate
    public void setUpdateTimestamp() {
        this.last_update = LocalDateTime.now();  // Always update timestamp on update
    }

}
