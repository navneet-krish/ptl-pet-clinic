package com.babu.ptl.ptlpetclinic.bootstrap;

import com.babu.ptl.ptlpetclinic.model.Owner;
import com.babu.ptl.ptlpetclinic.model.Pet;
import com.babu.ptl.ptlpetclinic.model.PetType;
import com.babu.ptl.ptlpetclinic.model.Vet;
import com.babu.ptl.ptlpetclinic.services.OwnerService;
import com.babu.ptl.ptlpetclinic.services.PetTypeService;
import com.babu.ptl.ptlpetclinic.services.VetService;
import com.babu.ptl.ptlpetclinic.services.map.OwnerServiceMap;
import com.babu.ptl.ptlpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

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

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mini");
        vet2.setLastName("Mo");

        vetService.save(vet2);

        System.out.println("Vets Loaded.....");
    }
}
