package com.muzzy.petclinic.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pet extends BaseEntity{
    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinTable(name="type_id")
    private PetType petType;

    @ManyToOne
    @JoinTable(name="owner_id")
    private Owner owner;

    @Column(name="birth_day")
    private LocalDate brithDay;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    public String getName() {
        return name;
    }

    public Pet setName(String name) {
        this.name = name;
        return this;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBrithDay() {
        return brithDay;
    }

    public void setBrithDay(LocalDate brithDay) {
        this.brithDay = brithDay;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public Pet setVisits(Set<Visit> visits) {
        this.visits = visits;
        return this;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", petType=" + petType.getId() + " , " +petType.getName() +
                ", owner=" + owner +
                ", brithDay=" + brithDay +
                '}';
    }
}
