package com.babu.ptl.ptlpetclinic.services;

import com.babu.ptl.ptlpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
