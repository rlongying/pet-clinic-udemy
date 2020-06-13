package learn.spring.petclinic.service.map;

import learn.spring.petclinic.model.Speciality;
import learn.spring.petclinic.service.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {

}
