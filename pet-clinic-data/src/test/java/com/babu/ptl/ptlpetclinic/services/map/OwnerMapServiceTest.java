package com.babu.ptl.ptlpetclinic.services.map;

import com.babu.ptl.ptlpetclinic.model.Owner;
import com.babu.ptl.ptlpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    long ownerId = 1l;
    String lastName = "NSharma";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(1,ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);

        assertEquals(ownerId, owner.getId());

    }

    @Test
    void saveExistingId() {

        long ownerId2 = 2l;

        Owner owner2 = Owner.builder().id(ownerId2).build();
        Owner ownerSaved = ownerMapService.save(owner2);

        assertEquals(ownerId2, ownerSaved.getId());
    }

    @Test
    void saveNoId() {
        Owner owner3 = Owner.builder().build();
        Owner savedOwner = ownerMapService.save(owner3);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
        assertEquals(2, savedOwner.getId());

    }
    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteByID() {
        ownerMapService.deleteByID(ownerId);
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {

        Owner smith = ownerMapService.findByLastName(lastName);

        assertNotNull(smith);
        assertEquals("NSharma",smith.getLastName());
    }
}