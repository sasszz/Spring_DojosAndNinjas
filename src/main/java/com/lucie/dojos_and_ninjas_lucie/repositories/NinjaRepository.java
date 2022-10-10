package com.lucie.dojos_and_ninjas_lucie.repositories;

import com.lucie.dojos_and_ninjas_lucie.models.Dojo;
import com.lucie.dojos_and_ninjas_lucie.models.Ninja;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
    // this method retrieves all the books from the database
    List<Ninja> findAll();
//    // this method finds books with descriptions containing the search string
//    List<Dojo> findByDescriptionContaining(String search);
//    // this method counts how many titles contain a certain string
//    Long countByTitleContaining(String search);
//    // this method deletes a book that starts with a specific title
//    Long deleteByTitleStartingWith(String search);
}
