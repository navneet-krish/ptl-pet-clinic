package com.babu.ptl.ptlpetclinic.services.map;

import com.babu.ptl.ptlpetclinic.model.Pet;
import com.babu.ptl.ptlpetclinic.services.CrudService;
import com.babu.ptl.ptlpetclinic.services.PetService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(),object);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        super.deleteById(aLong);
    }
}
