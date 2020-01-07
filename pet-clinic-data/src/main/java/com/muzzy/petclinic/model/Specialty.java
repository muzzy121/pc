package com.muzzy.petclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="specialties")
public class Specialty extends BaseEntity {
    @Column(name="description")
    private String description;


}
