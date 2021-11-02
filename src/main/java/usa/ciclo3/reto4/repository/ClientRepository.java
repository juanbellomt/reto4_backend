package usa.ciclo3.reto4.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo3.reto4.model.Client;
import usa.ciclo3.reto4.repository.crud.ClientCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll() {
        return (List<Client>)clientCrudRepository.findAll();
    }
    public Optional<Client> getClient(int id) {
        return clientCrudRepository.findById(id);
    }
    public Client save(Client cl) {
        return clientCrudRepository.save(cl);
    }
    public void delete(Client cl) {
        clientCrudRepository.delete(cl);
    }
}