package com.muzzy.petclinic.bootstrap;

import com.muzzy.petclinic.model.Owner;
import com.muzzy.petclinic.model.Vet;
import com.muzzy.petclinic.services.OwnerService;
import com.muzzy.petclinic.services.VetService;
import com.muzzy.petclinic.services.map.OwnerServiceMap;
import com.muzzy.petclinic.services.map.VetServiceMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    //Runs after Sprig will finish create context
    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Janusz");
        owner.setLastName("Nosacz");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Janina");
        owner2.setLastName("Nosaczowa");

        ownerService.save(owner);
        ownerService.save(owner2);

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Pawel");
        vet.setLastName("Mazur");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Justyna");
        vet2.setLastName("Mazur");

        vetService.save(vet);
        vetService.save(vet2);


    }
}
