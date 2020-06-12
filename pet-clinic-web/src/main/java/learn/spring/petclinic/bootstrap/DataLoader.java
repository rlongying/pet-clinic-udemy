package learn.spring.petclinic.bootstrap;

import learn.spring.petclinic.model.*;
import learn.spring.petclinic.service.OwnerService;
import learn.spring.petclinic.service.PetTypeService;
import learn.spring.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;

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
        PetType saveCatPetType = petTypeService.save(cat);


        Owner owner1 = createPerson(Owner.class,"Michael", "Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Weston");
        owner1.setTelephone("1233452");
        ownerService.save(owner1);

        Owner owner2 = createPerson(Owner.class,"Fiona", "Glenanne");
        owner2.setAddress("234 Union");
        owner2.setCity("Eastern");
        owner2.setTelephone("1231414");
        ownerService.save(owner2);
        System.out.println("Loaded owners...");

        Pet mikespet = new Pet();
        mikespet.setPetType(savedDogPetType);
        mikespet.setOwner(owner1);
        mikespet.setBirthDate(LocalDate.now());
        mikespet.setName("Rosco");
        owner1.getPets().add(mikespet);

        Pet fionasCat = new Pet();
        fionasCat.setPetType(saveCatPetType);
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setName("Rosco");
        owner2.getPets().add(fionasCat);


        Vet vet1 = createPerson(Vet.class,"Sam", "Axe");
        Vet vet2 = createPerson(Vet.class,"Jessie", "Porter");
        vetService.save(vet1);
        vetService.save(vet2);
        System.out.println("Loaded vets...");
    }

    private <T extends Person> T createPerson(Class<T> clazz, String firstName, String lastName) {
        Constructor[] ctors = clazz.getConstructors();
        Constructor ctor = null;
        for (Constructor c : ctors) {
            if (c.getGenericParameterTypes().length == 0) {
                ctor = c;
                break;
            }
        }

        try {
            assert ctor != null;
            ctor.setAccessible(true);
            T instance = (T)ctor.newInstance();
            instance.setFirstName(firstName);
            instance.setLastName(lastName);
            return instance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
