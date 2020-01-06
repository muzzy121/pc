package com.muzzy.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="types")
public class PetType extends BaseEntity {
    @Column(name="name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "petType")
    private Set<Pet> pets = new HashSet<>();

    @Override
    public String toString() {
        return "PetType{" +
                "name='" + this.getId() +" , " +name + '\'' +
                '}';
    }
}
