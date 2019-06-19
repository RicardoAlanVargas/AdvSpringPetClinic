package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    Long ownerId = 1L;
    final String lastName = "Vargas";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set <Owner> ownerSet = ownerMapService.findAll();
        System.out.println("El tamaño es "+ownerSet.size());
        assertEquals(1,ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(id,savedOwner.getId());
        System.out.println(savedOwner.getId());
    }

    @Test
    void saveNoId(){
        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
        System.out.println(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0,ownerMapService.findAll().size()); //This is incomplete, just a happypath test
    }

    @Test
    void deleteById() {
        ownerMapService.delete(ownerMapService.findById(ownerId)); //This is incomplete, just a happypath test
        assertEquals(0,ownerMapService.findAll().size());

    }

    @Test
    void findByLastName() {
        Owner vargas = ownerMapService.findByLastName(lastName);
        assertNotNull(vargas);
        assertEquals(ownerId, vargas.getId());
    }

    @Test
    void findByLastNameNotFound(){
        Owner nullOwner = ownerMapService.findByLastName("null");
        assertNull(nullOwner);
    }
}