package usa.ciclo3.reto4.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo3.reto4.model.Farm;
import usa.ciclo3.reto4.repository.crud.FarmCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class FarmRepository {

    @Autowired
    private FarmCrudRepository farmCrudRepository;

    public List<Farm> getAll() {
        return (List<Farm>)farmCrudRepository.findAll();
    }
    public Optional<Farm> getFarm(int id) {
        return farmCrudRepository.findById(id);
    }
    public Farm save(Farm f) {
        return farmCrudRepository.save(f);
    }
    public void delete(Farm f) {
        farmCrudRepository.delete(f);
    }
}