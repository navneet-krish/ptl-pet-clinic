package com.babu.ptl.ptlpetclinic.services.map;


import com.babu.ptl.ptlpetclinic.model.PetType;
import com.babu.ptl.ptlpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeServiceMap extends AbstractMapService implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return (PetType) super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return (PetType) super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        super.deleteById(aLong);
    }
}
