package usa.ciclo3.reto4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto4.model.Category;
import usa.ciclo3.reto4.model.Message;
import usa.ciclo3.reto4.repository.MessageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int messageId) {
        return messageRepository.getMessage(messageId);
    }

    public Message save(Message m) {
        if(m.getIdMessage()==null) {
            return messageRepository.save(m);
        }else{
            Optional<Message> paux=messageRepository.getMessage(m.getIdMessage());
            if(paux.isEmpty()){
                return messageRepository.save(m);
            }else{
                return m;
            }
        }
    }

    public Message update(Message m) {
        if(m.getIdMessage()!=null) {
            Optional<Message> k=messageRepository.getMessage(m.getIdMessage());
            if(!k.isEmpty()) {
                if(m.getMessageText()!=null) {
                    k.get().setMessageText(m.getMessageText());
                }
                messageRepository.save(k.get());
                return k.get();
            }else{
                return m;
            }
        }else{
            return m;
        }
    }

    public boolean delete(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(f -> { messageRepository.delete(f); return true; }).orElse(false);
        return aBoolean;
    }


}