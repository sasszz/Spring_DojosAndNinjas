package com.lucie.dojos_and_ninjas_lucie.services;

import com.lucie.dojos_and_ninjas_lucie.models.Dojo;
import com.lucie.dojos_and_ninjas_lucie.repositories.DojoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojoService {
    private final DojoRepository repo;
    public DojoService(DojoRepository repo) {
        this.repo = repo;
    }
    // CREATE
    public Dojo create(Dojo dojo) {
        return repo.save(dojo);
    }
    // READ
    public List<Dojo> getAll() {
        return repo.findAll();
    }
    public Dojo getOne(Long id) {
        Optional<Dojo> dojo = repo.findById(id);
        return dojo.orElse(null);
    }
    // UPDATE
    public Dojo update(Dojo dojo) {
        Dojo l = getOne(dojo.getId());
        l.setName(dojo.getName());
        return repo.save(l);
    }
    //DELETE
    public void delete(Long id) {
        repo.deleteById(id);

    }
}
