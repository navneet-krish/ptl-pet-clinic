package com.babu.ptl.ptlpetclinic.services.springdatajpa;

import com.babu.ptl.ptlpetclinic.model.Owner;
import com.babu.ptl.ptlpetclinic.repositories.OwnerRepository;
import com.babu.ptl.ptlpetclinic.repositories.PetRepository;
import com.babu.ptl.ptlpetclinic.repositories.PetTypeRepository;
import com.babu.ptl.ptlpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerJPAService implements OwnerService {

    private OwnerRepository ownerRepository;
    private PetRepository petRepository;
    private PetTypeRepository petTypeRepository;

    public OwnerJPAService(OwnerRepository ownerRepository, PetRepository petRepository,
                           PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> ownerSet = new HashSet<>();

        ownerRepository.findAll().forEach(ownerSet::add);
        return ownerSet;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName);
    }
}
