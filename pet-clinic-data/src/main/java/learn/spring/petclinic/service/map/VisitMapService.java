package learn.spring.petclinic.service.map;

import learn.spring.petclinic.model.Visit;
import learn.spring.petclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Visit save(Visit visit) {
        if(visit == null || visit.getPet() == null) {
            throw new RuntimeException("Invalid Visit");
        }

        return super.save(visit);
    }
}
