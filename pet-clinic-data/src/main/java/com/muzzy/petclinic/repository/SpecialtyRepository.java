package com.muzzy.petclinic.repository;

import com.muzzy.petclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository  extends CrudRepository<Specialty, Long> {
}
