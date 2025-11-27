package com.validationofdb.dbapivalidation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.validationofdb.dbapivalidation.entity.actor;

@Repository
public interface actorrepo extends JpaRepository<actor,Integer>{

}
