package com.muzzy.petclinic.services;

import com.muzzy.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findByName(String name);

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}

