package com.babu.ptl.ptlpetclinic.services;

import com.babu.ptl.ptlpetclinic.model.Owner;

import java.util.List;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
