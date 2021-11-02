package usa.ciclo3.reto4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto4.model.Farm;
import usa.ciclo3.reto4.model.Reservation;
import usa.ciclo3.reto4.repository.ReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId){
        return reservationRepository.getReservation(reservationId);
    }

    public Reservation save(Reservation r){
        if(r.getIdReservation()==null){
            return reservationRepository.save(r);
        }else{
            Optional<Reservation> paux=reservationRepository.getReservation(r.getIdReservation());
            if(paux.isEmpty()){
                return reservationRepository.save(r);
            }else{
                return r;
            }
        }
    }

    public Reservation update(Reservation r) {
        if(r.getIdReservation()!=null) {
            Optional<Reservation> k=reservationRepository.getReservation(r.getIdReservation());
            if(!k.isEmpty()) {
                if(r.getStartDate()!=null) {
                    k.get().setStartDate(r.getStartDate());
                }
                if(r.getDevolutionDate()!=null) {
                    k.get().setDevolutionDate(r.getDevolutionDate());
                }
                if(r.getStatus()!=null) {
                    k.get().setStatus(r.getStatus());
                }

                reservationRepository.save(k.get());
                return k.get();
            }else{
                return r;
            }
        }else{
            return r;
        }
    }

    public boolean delete(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(f -> { reservationRepository.delete(f); return true; }).orElse(false);
        return aBoolean;
    }

}