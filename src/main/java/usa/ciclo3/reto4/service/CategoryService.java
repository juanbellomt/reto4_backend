package usa.ciclo3.reto4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto4.model.Category;
import usa.ciclo3.reto4.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category ca) {
        if(ca.getId()==null) {
            return categoryRepository.save(ca);
        }else{
            Optional<Category> paux=categoryRepository.getCategory(ca.getId());
            if(paux.isEmpty()){
                return categoryRepository.save(ca);
            }else{
                return ca;
            }
        }
    }

    public Category update(Category ca) {
        if(ca.getId()!=null) {
            Optional<Category> k=categoryRepository.getCategory(ca.getId());
            if(!k.isEmpty()) {
                if(ca.getName()!=null) {
                    k.get().setName(ca.getName());
                }
                if(ca.getDescription()!=null) {
                    k.get().setDescription(ca.getDescription());
                }
                categoryRepository.save(k.get());
                return k.get();
            }else{
                return ca;
            }
        }else{
            return ca;
        }
    }

    public boolean delete(int categoryId) {
        Boolean aBoolean = getCategory(categoryId).map(f -> { categoryRepository.delete(f); return true; }).orElse(false);
        return aBoolean;
    }

}
