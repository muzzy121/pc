package com.muzzy.petclinic.services.map;

import com.muzzy.petclinic.model.Vet;
import com.muzzy.petclinic.services.CrudService;
import com.muzzy.petclinic.services.VetService;

import java.util.Set;

public class VetServiceMap extends AbstractServiceMap<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet findByLastName(String lastName) {
        return null;
    }
}