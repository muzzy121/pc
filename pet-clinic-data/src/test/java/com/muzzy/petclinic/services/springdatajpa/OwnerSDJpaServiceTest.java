package com.muzzy.petclinic.services.springdatajpa;

import com.muzzy.petclinic.model.Owner;
import com.muzzy.petclinic.repository.OwnerRepository;
import com.muzzy.petclinic.repository.PetRepository;
import com.muzzy.petclinic.repository.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    //Create user to use it in mock
    long id = 1L;
    String lastName = "mazur";
    Owner owner = Owner.builder().id(id).lastName(lastName).build();

    @BeforeEach
    void setUp() {
    }


    @Test
    void findByLastName() {
        //Testing service findByLastName , Mock repository findByLastName
        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        Owner returnedOwner = ownerSDJpaService.findByLastName(lastName);
        assertEquals(owner, returnedOwner);
        verify(ownerRepository, times(1)).findByLastName(any());
    }

    @Test
    void findAll() {
        HashSet<Owner> owners = new HashSet<>();
        owners.add(owner);
        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> resultOwnerSet = ownerSDJpaService.findAll();
        assertEquals(1, resultOwnerSet.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.ofNullable(owner));
        Owner returnedOwner = ownerSDJpaService.findById(id);
        assertEquals(owner.getId(), returnedOwner.getId());
        assertNotNull(returnedOwner);
    }
    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(any())).thenReturn(Optional.empty());
        Owner returnedOwner = ownerSDJpaService.findById(id);
        assertNull(returnedOwner);
    }


    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(owner);
        Owner savedOwner = ownerSDJpaService.save(owner);
        assertNotNull(savedOwner);

    }

    @Test
    void delete() {
        ownerSDJpaService.delete(owner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }
}