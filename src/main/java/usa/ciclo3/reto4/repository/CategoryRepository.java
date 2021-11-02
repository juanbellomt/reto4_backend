package usa.ciclo3.reto4.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo3.reto4.model.Category;
import usa.ciclo3.reto4.repository.crud.CategoryCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll() {
        return (List<Category>) categoryCrudRepository.findAll();
    }
    public Optional<Category> getCategory(int id) {
        return categoryCrudRepository.findById(id);
    }
    public Category save(Category ca) {
        return categoryCrudRepository.save(ca);
    }
    public void delete(Category ca) {
        categoryCrudRepository.delete(ca);
    }
}