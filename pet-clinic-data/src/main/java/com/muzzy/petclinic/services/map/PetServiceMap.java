package com.muzzy.petclinic.services.map;

import com.muzzy.petclinic.model.Pet;
import com.muzzy.petclinic.services.CrudService;
import com.muzzy.petclinic.services.PetService;

import java.util.Set;

public class PetServiceMap extends AbstractServiceMap<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet findByName(String name) {
        return null;
    }
}