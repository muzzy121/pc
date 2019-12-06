package com.muzzy.petclinic.bootstrap;

import com.muzzy.petclinic.model.Owner;
import com.muzzy.petclinic.services.OwnerService;
import com.muzzy.petclinic.services.VetService;
import com.muzzy.petclinic.services.map.OwnerServiceMap;
import com.muzzy.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;

public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Janusz");
        owner.setLastName("Nosacz");
        ownerService.save(owner);
    }
}
