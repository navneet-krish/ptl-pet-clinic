package com.babu.ptl.ptlpetclinic.bootstrap;

import com.babu.ptl.ptlpetclinic.model.Owner;
import com.babu.ptl.ptlpetclinic.model.PetType;
import com.babu.ptl.ptlpetclinic.model.Vet;
import com.babu.ptl.ptlpetclinic.services.OwnerService;
import com.babu.ptl.ptlpetclinic.services.PetTypeService;
import com.babu.ptl.ptlpetclinic.services.VetService;
import com.babu.ptl.ptlpetclinic.services.map.OwnerServiceMap;
import com.babu.ptl.ptlpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


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

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Tamneet");
        owner2.setLastName("Sharma");

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
