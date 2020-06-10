package learn.spring.petclinic.bootstrap;

import learn.spring.petclinic.model.Owner;
import learn.spring.petclinic.model.Person;
import learn.spring.petclinic.model.Vet;
import learn.spring.petclinic.service.OwnerService;
import learn.spring.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = createPerson(Owner.class,"Michael", "Weston");
        ownerService.save(owner1);

        Owner owner2 = createPerson(Owner.class,"Fiona", "Glenanne");
        ownerService.save(owner2);
        System.out.println("Loaded owners...");

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
