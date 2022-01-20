package com.babu.ptl.ptlpetclinic.services;

import com.babu.ptl.ptlpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
