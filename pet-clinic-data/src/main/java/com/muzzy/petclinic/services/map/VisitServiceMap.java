package com.muzzy.petclinic.services.map;

import com.muzzy.petclinic.model.Visit;
import com.muzzy.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default","map"})
public class VisitServiceMap extends AbstractServiceMap<Visit,Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit object) {
        if(object.getPet() != null || object.getPet().getOwner() != null || object.getPet().getPetType() != null){
            return super.save(object);
        } else throw new RuntimeException("Visit have no proper pet object");
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
