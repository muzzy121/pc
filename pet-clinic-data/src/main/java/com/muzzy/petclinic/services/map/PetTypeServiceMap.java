package com.muzzy.petclinic.services.map;

import com.muzzy.petclinic.model.PetType;
import com.muzzy.petclinic.services.PetTypeService;

import java.util.Set;

public class PetTypeServiceMap extends AbstractServiceMap<PetType, Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
