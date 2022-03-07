package com.babu.ptl.ptlpetclinic.controllers;

import com.babu.ptl.ptlpetclinic.model.Owner;
import com.babu.ptl.ptlpetclinic.model.Pet;
import com.babu.ptl.ptlpetclinic.model.PetType;
import com.babu.ptl.ptlpetclinic.model.Visit;
import com.babu.ptl.ptlpetclinic.services.OwnerService;
import com.babu.ptl.ptlpetclinic.services.PetService;
import com.babu.ptl.ptlpetclinic.services.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class VisitControllerTest {

    @Mock
    PetService petService;
    @Mock
    VisitService visitService;
    @Mock
    OwnerService ownerService;

    @InjectMocks
    VisitController visitController;

    MockMvc mockMvc;

    Long petId = 1L;
    Long ownerId = 1L;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();
    }

    @Test
    void initNewVisitForm() throws Exception {

        when(petService.findById(anyLong()))
                .thenReturn(
                        Pet.builder()
                                .id(petId)
                                .birthDate(LocalDate.of(2018,11,13))
                                .name("Kutie")
                                .visits(new HashSet<>())
                                .owner(Owner.builder()
                                        .id(ownerId)
                                        .lastName("NSharma")
                                        .firstName("Navneet")
                                        .build())
                                .petType(PetType.builder()
                                        .name("Dog").build())
                                .build()
                );


        mockMvc.perform(get("/owners/1/pets/1/visits/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdateVisitForm"));
    }

    @Test
    void processNewVisitForm() throws Exception {

        when(petService.findById(anyLong()))
                .thenReturn(
                        Pet.builder()
                                .id(petId)
                                .birthDate(LocalDate.of(2018,11,13))
                                .name("Kutie")
                                .visits(new HashSet<>())
                                .owner(Owner.builder()
                                        .id(ownerId)
                                        .lastName("NSharma")
                                        .firstName("Navneet")
                                        .build())
                                .petType(PetType.builder()
                                        .name("Dog").build())
                                .build()
                );

        mockMvc.perform(post("/owners/1/pets/1/visits/new")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("date","2018-11-11")
                        .param("description", "description"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/{ownerId}"))
                .andExpect(model().attributeExists("visit"))
        ;
    }
}