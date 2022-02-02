package com.babu.ptl.ptlpetclinic.services.springdatajpa;

import com.babu.ptl.ptlpetclinic.model.PetType;
import com.babu.ptl.ptlpetclinic.repositories.PetTypeRepository;
import com.babu.ptl.ptlpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeJPAService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeJPAService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypeSet = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypeSet::add);
        return petTypeSet;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
            petTypeRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
            petTypeRepository.deleteById(aLong);
    }
}
