package com.muzzy.petclinic.repository;

import com.muzzy.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
    Pet findFirstByName(String name);
}
