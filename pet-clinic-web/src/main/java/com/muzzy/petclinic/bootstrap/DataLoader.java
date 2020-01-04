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
    private final VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }


    //Runs after Sprig will finish create context
    @Override
    public void run(String... args) throws Exception {
        if (petTypeService.findAll().size() == 0 ) {
            loadData();
        }
    }

    private void loadData() {
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

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
//        specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentist");
        specialtyService.save(dentistry);

        Vet vet = new Vet();
//        vet.setId(1L);
        vet.setFirstName("Pawel");
        vet.setLastName("Mazur");
        vet.getSpecialtySet().add(radiology);

        Vet vet2 = new Vet();
//        vet2.setId(2L);
        vet2.setFirstName("Justyna");
        vet2.setLastName("Mazur");
        vet2.getSpecialtySet().add(surgery);

        vetService.save(vet);
        vetService.save(vet2);

        Visit visit = new Visit();
        visit.setDate(LocalDate.now().plusDays(10));
        visit.setDescription("Visit for my poor sick Cat");
        visit.setPet(piorun);
        visitService.save(visit);
    }
}
