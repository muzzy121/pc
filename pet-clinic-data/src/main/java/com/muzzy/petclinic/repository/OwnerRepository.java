package com.muzzy.petclinic.repository;

import com.muzzy.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName); // why 1. He establish that he will find something. 2. there can be more than one owner with the same lastname
}
// TODO: 2020-01-03 Check all repositories, update the way how he gets data in these queries