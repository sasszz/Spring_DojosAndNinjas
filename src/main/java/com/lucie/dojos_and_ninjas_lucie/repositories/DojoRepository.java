package com.lucie.dojos_and_ninjas_lucie.repositories;

import com.lucie.dojos_and_ninjas_lucie.models.Dojo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
    // this method retrieves all the books from the database
    List<Dojo> findAll();
}
