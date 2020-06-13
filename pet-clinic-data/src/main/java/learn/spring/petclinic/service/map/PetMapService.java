package learn.spring.petclinic.service.map;

import learn.spring.petclinic.model.Pet;
import learn.spring.petclinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

}
