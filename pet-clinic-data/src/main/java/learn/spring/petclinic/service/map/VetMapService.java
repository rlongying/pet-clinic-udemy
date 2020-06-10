package learn.spring.petclinic.service.map;

import learn.spring.petclinic.model.Vet;
import learn.spring.petclinic.service.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

}
