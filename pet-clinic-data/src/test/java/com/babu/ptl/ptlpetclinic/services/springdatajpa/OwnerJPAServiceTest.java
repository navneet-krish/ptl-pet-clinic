package com.babu.ptl.ptlpetclinic.services.springdatajpa;

import com.babu.ptl.ptlpetclinic.model.Owner;
import com.babu.ptl.ptlpetclinic.repositories.OwnerRepository;
import com.babu.ptl.ptlpetclinic.repositories.PetRepository;
import com.babu.ptl.ptlpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {

    private static final String LAST_NAME = "NSharma";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerJPAService ownerJPAService;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner =  Owner.builder().id(1l).lastName(LAST_NAME).build();
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(1l).build());
        ownerSet.add(Owner.builder().id(2l).build());

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> owners = ownerJPAService.findAll();
        assertEquals(2,owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner = ownerJPAService.findById(1L);
        assertNotNull(owner);
    }

    @Test
    void save() {

        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner saveOwner = ownerRepository.save(returnOwner);

        assertNotNull(saveOwner);
    }

    @Test
    void delete() {
        ownerRepository.delete(returnOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteByID() {
        ownerRepository.deleteById(1l);
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {



        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner sharma = ownerJPAService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME,sharma.getLastName());

        verify(ownerRepository).findByLastName(any());

    }
}