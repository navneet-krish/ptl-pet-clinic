package com.babu.ptl.ptlpetclinic.bootstrap;

import com.babu.ptl.ptlpetclinic.model.Owner;
import com.babu.ptl.ptlpetclinic.model.Vet;
import com.babu.ptl.ptlpetclinic.services.OwnerService;
import com.babu.ptl.ptlpetclinic.services.VetService;
import com.babu.ptl.ptlpetclinic.services.map.OwnerServiceMap;
import com.babu.ptl.ptlpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Navneet");
        owner1.setLastName("Sharma");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Tamneet");
        owner2.setLastName("Sharma");

        ownerService.save(owner2);

        System.out.println("Owners Loaded....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Joe");
        vet1.setLastName("Loe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Mini");
        vet2.setLastName("Mo");

        vetService.save(vet2);

        System.out.println("Vets Loaded.....");
    }
}