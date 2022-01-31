package com.babu.ptl.ptlpetclinic.repositories;

import com.babu.ptl.ptlpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
