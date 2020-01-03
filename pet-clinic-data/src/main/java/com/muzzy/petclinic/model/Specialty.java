package com.muzzy.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name="specialties")
public class Specialty extends BaseEntity {
    @Column(name="description")
    private String description;

    public String getDescription() {
        return description;
    }

    public Specialty setDescription(String description) {
        this.description = description;
        return this;
    }
}
