package com.muzzy.petclinic.bootstrap;

import com.muzzy.petclinic.model.*;
import com.muzzy.petclinic.services.*;
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
    private final SpecialtyService specialtyService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialtyService = specialtyService;
    }


    //Runs after Sprig will finish create context
    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner = new Owner();
//        owner.setId(1L);
        owner.setFirstName("Janusz");
        owner.setLastName("Nosacz");
        owner.setAddress("Konopnickiej 6/1");
        owner.setCity("Olkusz");
        owner.setTelephone("606001002");

        Owner owner2 = new Owner();
//        owner2.setId(2L);
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
//        petService.save(piorun);

        owner.getPets().add(piorun);
        ownerService.save(owner);

        Pet tore = new Pet();
        tore.setPetType(savedDogType);
        tore.setName("Tore");
        tore.setOwner(owner2);
        tore.setBrithDay(LocalDate.now().minusYears(5));
//        petService.save(tore);

        owner2.getPets().add(tore);
        ownerService.save(owner2);

        Specialty catSpecialist = new Specialty();
        catSpecialist.setDescription("Heals cats");
//        specialtyService.save(catSpecialist);

        Specialty dogSpecialist = new Specialty();
        dogSpecialist.setDescription("Heals dogs");
        specialtyService.save(dogSpecialist);

        Vet vet = new Vet();
//        vet.setId(1L);
        vet.setFirstName("Pawel");
        vet.setLastName("Mazur");
        vet.getSpecialtySet().add(catSpecialist);

        Vet vet2 = new Vet();
//        vet2.setId(2L);
        vet2.setFirstName("Justyna");
        vet2.setLastName("Mazur");
        vet2.getSpecialtySet().add(dogSpecialist);

        vetService.save(vet);
        vetService.save(vet2);




    }
}
