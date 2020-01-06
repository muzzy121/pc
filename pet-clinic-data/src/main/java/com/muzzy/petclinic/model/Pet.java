package com.muzzy.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
