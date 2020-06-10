package learn.spring.petclinic.service.map;

import learn.spring.petclinic.model.Pet;
import learn.spring.petclinic.service.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

}
