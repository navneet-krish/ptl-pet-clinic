package com.babu.ptl.ptlpetclinic.repositories;

import com.babu.ptl.ptlpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
