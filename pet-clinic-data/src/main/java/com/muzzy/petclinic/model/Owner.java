package com.muzzy.petclinic.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="owners")
public class Owner extends Person {
    @Column(name="address")
    private String address;
    @Column(name="city")
    private String city;
    @Column(name="telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    public String getAddress() {
        return address;
    }

    public Owner setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Owner setCity(String city) {
        this.city = city;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public Owner setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public Owner setPets(Set<Pet> pets) {
        this.pets = pets;
        return this;
    }
}

