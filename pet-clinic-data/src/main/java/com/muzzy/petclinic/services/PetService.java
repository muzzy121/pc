package com.muzzy.petclinic.services;

import com.muzzy.petclinic.model.Pet;

import java.util.Set;

public interface PetService extends CrudService<Pet, Long> {
    Pet findByName(String name);
}

