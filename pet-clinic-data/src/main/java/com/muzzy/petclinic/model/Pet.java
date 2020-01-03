package com.muzzy.petclinic.model;

import javax.persistence.*;
import java.time.LocalDate;

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
