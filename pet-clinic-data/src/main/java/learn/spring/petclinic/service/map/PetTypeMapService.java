package learn.spring.petclinic.service.map;

import learn.spring.petclinic.model.PetType;
import learn.spring.petclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

}
