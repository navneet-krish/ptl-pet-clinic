package com.babu.ptl.ptlpetclinic.services.map;

import com.babu.ptl.ptlpetclinic.model.Owner;
import com.babu.ptl.ptlpetclinic.services.CrudService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(),object);
    }

    @Override
    public void delete(Owner object) {
            super.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
            super.deleteById(aLong);
    }

}
