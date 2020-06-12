package learn.spring.petclinic.service;

import learn.spring.petclinic.model.Speciality;
import org.springframework.stereotype.Service;

@Service
public interface SpecialityService extends CrudService<Speciality, Long> {
}
