package learn.spring.petclinic.service;

import learn.spring.petclinic.model.Owner;
import learn.spring.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
