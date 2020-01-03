package com.muzzy.petclinic.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visits")
public class Visit extends BaseEntity{
    @Column(name="date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="pet_id")
    private Pet pet;

    @Column(name="description")
    private String description;

    public LocalDate getDate() {
        return date;
    }

    public Visit setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Pet getPet() {
        return pet;
    }

    public Visit setPet(Pet pet) {
        this.pet = pet;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Visit setDescription(String description) {
        this.description = description;
        return this;
    }
}
