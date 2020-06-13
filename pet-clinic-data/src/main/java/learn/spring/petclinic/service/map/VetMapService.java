package learn.spring.petclinic.service.map;

import learn.spring.petclinic.model.Speciality;
import learn.spring.petclinic.model.Vet;
import learn.spring.petclinic.service.SpecialityService;
import learn.spring.petclinic.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet object) {
        if (object == null) return null;

        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(s -> {
                if (s.getId() == null) {
                    s.setId(specialityService.save(s).getId());
                }
            });
        }
        return super.save(object);
    }
}
