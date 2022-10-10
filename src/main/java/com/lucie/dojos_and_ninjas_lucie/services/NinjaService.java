package com.lucie.dojos_and_ninjas_lucie.services;

import com.lucie.dojos_and_ninjas_lucie.models.Ninja;
import com.lucie.dojos_and_ninjas_lucie.repositories.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private final NinjaRepository repo;
    public NinjaService(NinjaRepository repo) {
        this.repo = repo;
    }
    // CREATE
    public Ninja create(Ninja ninja) {
        return repo.save(ninja);
    }
    // READ
    public List<Ninja> getAll() {
        return repo.findAll();
    }
    public Ninja getOne(Long id) {
        Optional<Ninja> ninja = repo.findById(id);
        return ninja.orElse(null);
    }
    // UPDATE
    public Ninja update(Ninja ninja) {
        Ninja l = getOne(ninja.getId());
        l.setFirstName(ninja.getFirstName());
        l.setLastName(ninja.getLastName());
        l.setAge(ninja.getAge());
        l.setDojo(ninja.getDojo());
        return repo.save(l);
    }
    //DELETE
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
