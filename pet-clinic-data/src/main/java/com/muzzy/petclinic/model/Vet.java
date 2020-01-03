package com.muzzy.petclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Vet extends Person {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name="vet_id"),
                        inverseJoinColumns = @JoinColumn(name="speciality_id"))
    private Set<Specialty> specialtySet = new HashSet<>();

    public Set<Specialty> getSpecialtySet() {
        return specialtySet;
    }

    public Vet setSpecialtySet(Set<Specialty> specialtySet) {
        this.specialtySet = specialtySet;
        return this;
    }
}
