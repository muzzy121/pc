package com.muzzy.petclinic.bootstrap;

import com.muzzy.petclinic.model.Owner;
import com.muzzy.petclinic.model.Pet;
import com.muzzy.petclinic.model.PetType;
import com.muzzy.petclinic.model.Vet;
import com.muzzy.petclinic.services.OwnerService;
import com.muzzy.petclinic.services.PetService;
import com.muzzy.petclinic.services.PetTypeService;
import com.muzzy.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }


    //Runs after Sprig will finish create context
    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);
        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);





        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Janusz");
        owner.setLastName("Nosacz");
        owner.setAddress("Konopnickiej 6/1");
        owner.setCity("Olkusz");
        owner.setTelephone("606001002");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Janina");
        owner2.setLastName("Nosaczowa");
        owner2.setAddress("Reja 1/1");
        owner2.setCity("Olkusz");
        owner2.setTelephone("706222002");




        Pet piorun = new Pet();
        piorun.setPetType(savedCatType);
        piorun.setName("Piorun");
        piorun.setOwner(owner);
        piorun.setBrithDay(LocalDate.now().minusYears(2));
        owner.getPets().add(piorun);

        ownerService.save(owner);
        petService.save(piorun);

        Pet tore = new Pet();
        tore.setPetType(savedDogType);
        tore.setName("Tore");
        tore.setOwner(owner2);
        tore.setBrithDay(LocalDate.now().minusYears(5));
        owner2.getPets().add(tore);

        ownerService.save(owner2);
        petService.save(tore);

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
