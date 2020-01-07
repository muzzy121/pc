package com.muzzy.petclinic.repository;

import com.muzzy.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface VetRepository extends CrudRepository<Vet,Long> {
    Optional<Vet> findFirstByLastName(String lastName);
}
