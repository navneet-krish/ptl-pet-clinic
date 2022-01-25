package com.babu.ptl.ptlpetclinic.bootstrap;

import com.babu.ptl.ptlpetclinic.model.*;
import com.babu.ptl.ptlpetclinic.services.OwnerService;
import com.babu.ptl.ptlpetclinic.services.PetTypeService;
import com.babu.ptl.ptlpetclinic.services.SpecialityService;
import com.babu.ptl.ptlpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Navneet");
        owner1.setLastName("Sharma");
        owner1.setAddress("Bangalore");
        owner1.setCity("Bangalore");
        owner1.setTelephone("123456789");

        Pet navPet = new Pet();
        navPet.setPetType(savedDogPetType);
        navPet.setOwner(owner1);
        navPet.setBirthDate(LocalDate.now());
        navPet.setName("Jimmy");
        owner1.getPets().add(navPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Tamneet");
        owner2.setLastName("Sharma");
        owner2.setAddress("Greater Noida");
        owner2.setCity("Noida");
        owner2.setTelephone("123456789");

        Pet tamPet = new Pet();
        tamPet.setPetType(savedCatPetType);
        tamPet.setOwner(owner2);
        tamPet.setBirthDate(LocalDate.now());
        tamPet.setName("Meow");
        owner2.getPets().add(tamPet);

        ownerService.save(owner2);

        System.out.println("Owners Loaded....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Joe");
        vet1.setLastName("Loe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mini");
        vet2.setLastName("Mo");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Vets Loaded.....");
    }
}
