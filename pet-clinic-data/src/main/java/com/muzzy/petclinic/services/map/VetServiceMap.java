package com.muzzy.petclinic.services.map;

import com.muzzy.petclinic.model.Specialty;
import com.muzzy.petclinic.model.Vet;
import com.muzzy.petclinic.services.SpecialtyService;
import com.muzzy.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractServiceMap<Vet, Long> implements VetService {
    private SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }


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
        if (object.getSpecialtySet() != null) {
            object.getSpecialtySet().forEach(specialty -> {
                if (specialty.getId() == null) {
                    Specialty savedSpeciality = specialtyService.save(specialty);
                    specialty.setId(savedSpeciality.getId());
                }
            });
            return super.save(object);
        } else {
            throw new RuntimeException("Speciality cannot be null");
        }
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
