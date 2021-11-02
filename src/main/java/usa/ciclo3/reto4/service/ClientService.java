package usa.ciclo3.reto4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto4.model.Client;
import usa.ciclo3.reto4.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int clientId) {
        return clientRepository.getClient(clientId);
    }

    public Client save(Client cl) {
        if(cl.getIdClient()==null) {
            return clientRepository.save(cl);
        }else{
            Optional<Client> paux= clientRepository.getClient(cl.getIdClient());
            if(paux.isEmpty()){
                return clientRepository.save(cl);
            }else{
                return cl;
            }
        }
    }

    public Client update(Client cl) {
        if(cl.getIdClient()!=null) {
            Optional<Client> k=clientRepository.getClient(cl.getIdClient());
            if(!k.isEmpty()) {

                if(cl.getEmail()!=null) {
                    k.get().setEmail(cl.getEmail());
                }
                if(cl.getPassword()!=null) {
                    k.get().setPassword(cl.getPassword());
                }
                if(cl.getName()!=null) {
                    k.get().setName(cl.getName());
                }
                if(cl.getAge()!=null) {
                    k.get().setAge(cl.getAge());
                }
                clientRepository.save(k.get());
                return k.get();
            }else{
                return cl;
            }
        }else{
            return cl;
        }
    }

    public boolean delete(int clientId) {
        Boolean aBoolean = getClient(clientId).map(f -> { clientRepository.delete(f); return true; }).orElse(false);
        return aBoolean;
    }

}