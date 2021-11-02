package usa.ciclo3.reto4.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto4.model.Farm;
import usa.ciclo3.reto4.repository.FarmRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FarmService {

    @Autowired
    private FarmRepository farmRepository;

    public List<Farm> getAll() {
        return farmRepository.getAll();
    }

    public Optional<Farm> getFarm(int idFinca) {
        return farmRepository.getFarm(idFinca);
    }

    public Farm save(Farm f) {
        if(f.getId()==null) {
            return farmRepository.save(f);
        }else{
            Optional<Farm> paux=farmRepository.getFarm(f.getId());
            if(paux.isEmpty()){
                return farmRepository.save(f);
            }else{
                return f;
            }
        }
    }

    public Farm update(Farm f) {
        if(f.getId()!=null) {
            Optional<Farm> k=farmRepository.getFarm(f.getId());
            if(!k.isEmpty()) {
                if(f.getName()!=null) {
                    k.get().setName(f.getName());
                }
                if(f.getAddress()!=null) {
                    k.get().setAddress(f.getAddress());
                }
                if(f.getExtension()!=null) {
                    k.get().setExtension(f.getExtension());
                }
                if(f.getDescription()!=null) {
                    k.get().setDescription(f.getDescription());
                }
                farmRepository.save(k.get());
                return k.get();
            }else{
                return f;
            }
        }else{
            return f;
        }
    }

public boolean delete(int farmId) {
        Boolean aBoolean = getFarm(farmId).map(f -> { farmRepository.delete(f); return true; }).orElse(false);
        return aBoolean;
}

}
