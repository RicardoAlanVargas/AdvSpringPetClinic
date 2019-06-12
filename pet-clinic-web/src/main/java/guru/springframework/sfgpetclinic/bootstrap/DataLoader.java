package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by jt on 7/25/18.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Ricardo");
        owner1.setLastName("Vargas");
        owner1.setAddress("Arandas 318");
        owner1.setCity("CDMX");
        owner1.setTelephone("5512345555");

        Pet richardPet = new Pet();
        richardPet.setPetType(savedDogPetType);
        richardPet.setOwner(owner1);
        richardPet.setBirthDate(LocalDate.now());
        richardPet.setName("Harry The Dog");
        owner1.getPets().add(richardPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Claudia");
        owner2.setLastName("Elizalde");
        owner2.setAddress("Progreso 124");
        owner2.setCity("San Luis Potosi");
        owner2.setTelephone("5598765543");

        Pet claudiasCat = new Pet();
        claudiasCat.setPetType(savedCatPetType);
        claudiasCat.setOwner(owner2);
        claudiasCat.setBirthDate(LocalDate.now());
        claudiasCat.setName("Candy");
        owner2.getPets().add(claudiasCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Bob");
        vet1.setLastName("El Doctor");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Noe");
        vet2.setLastName("Franco");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
