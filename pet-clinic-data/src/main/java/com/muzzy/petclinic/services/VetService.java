package com.muzzy.petclinic.services;

import com.muzzy.petclinic.model.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet, Long>{
    Vet findByLastName(String lastName);
}

