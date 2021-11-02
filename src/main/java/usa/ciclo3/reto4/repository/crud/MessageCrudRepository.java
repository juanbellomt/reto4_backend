package usa.ciclo3.reto4.repository.crud;

import org.springframework.data.repository.CrudRepository;
import usa.ciclo3.reto4.model.Message;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}