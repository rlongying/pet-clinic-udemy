package learn.spring.petclinic.service.map;

import learn.spring.petclinic.model.Owner;
import learn.spring.petclinic.service.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
