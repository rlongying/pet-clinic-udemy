package learn.spring.petclinic.service.map;

import learn.spring.petclinic.model.Owner;
import learn.spring.petclinic.model.Pet;
import learn.spring.petclinic.service.OwnerService;
import learn.spring.petclinic.service.PetService;
import learn.spring.petclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner save(Owner object) {

        if (object == null) {
            return null;
        }

        if(object.getPets() != null) {
            object.getPets().forEach(pet -> {
                if (pet.getPetType() == null) {
                    throw new RuntimeException("Pet Type is required");
                }
                if (pet.getPetType().getId() == null) {
                    pet.setPetType(petTypeService.save(pet.getPetType()));
                }
                if (pet.getId() == null) {
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
        }

        return super.save(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
