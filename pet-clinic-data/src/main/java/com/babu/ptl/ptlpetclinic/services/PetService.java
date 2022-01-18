package com.babu.ptl.ptlpetclinic.services;

import com.babu.ptl.ptlpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();

}
