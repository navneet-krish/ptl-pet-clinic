package com.babu.ptl.ptlpetclinic.services.map;

import com.babu.ptl.ptlpetclinic.model.Owner;
import com.babu.ptl.ptlpetclinic.model.Pet;
import com.babu.ptl.ptlpetclinic.services.OwnerService;
import com.babu.ptl.ptlpetclinic.services.PetService;
import com.babu.ptl.ptlpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Profile({"default","map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

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

        if(object != null){
            if (object.getPets() != null){
                object.getPets().forEach(pet -> {
                        if(pet.getPetType() != null){
                            System.out.println("get Pet Type " + pet.getName());
                            if(pet.getPetType().getId() == null){
                                pet.setPetType(petTypeService.save(pet.getPetType()));
                            } else {
                                System.out.println("Already have saved data...so no worries");
                            }
                            if(pet.getId() == null){
                                Pet savedPet = petService.save(pet);
                                pet.setId(savedPet.getId());
                            }
                        }
                });
            }
            return super.save(object);
        } else {
            return null;
        }

    }

    @Override
    public void delete(Owner object) {
            super.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
            super.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        Owner owner1 = this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
        return owner1;
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return null;
    }
}
