package com.cinema.service.reservation;


import com.cinema.dto.ReservationRequestDTO;
import com.cinema.model.Reservation;
import com.cinema.model.Session;
import com.cinema.exception.ReservationException;
import com.cinema.repository.ReservationRepository;
import com.cinema.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{
    private final ReservationRepository reservationRepository;
    private final SessionRepository sessionRepository;
    public List<Reservation> getReservations(){
        return reservationRepository.findAll();
    }

    @Override
    public boolean createReservation(Long id, ReservationRequestDTO reservationRequestDTO) throws ReservationException {
        ReservationServiceImpl reservationService=new ReservationServiceImpl(reservationRepository,sessionRepository);
        ReservationServiceImpl.generateHall(reservationRequestDTO.getHall());
        ReservationServiceImpl.generateRowAndPlace(reservationRequestDTO.getRow(), reservationRequestDTO.getPlace());
        reservationService.reservationExamination(id,reservationRequestDTO.getHall(),reservationRequestDTO.getRow(),reservationRequestDTO.getPlace());
        Reservation reservation=new Reservation();
        reservation.setHall(reservationRequestDTO.getHall());
        reservation.setRow(reservationRequestDTO.getRow());
        reservation.setPlace(reservationRequestDTO.getPlace());
        reservationRepository.save(reservation);
        return true;
    }

    @Override
    public Optional<Reservation> getReservationById(Long id) throws ReservationException {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isPresent()) {
            return Optional.of(reservation.orElseGet(Reservation::new));
        } else {
            throw new ReservationException("This reservation doesn't exist");
        }
    }
    private static void generateHall(int hall) throws ReservationException {
        if (hall > 0 && hall <= 3) {
        } else {
            throw new ReservationException("You have chosen the wrong hall");
        }
    }
    private void reservationExamination(Long id,  int hall, int row, int place)
            throws ReservationException {

        Session session=sessionRepository.findById(id).get();
        List<Reservation>reservationList=reservationRepository.findAll();
        for(Reservation num:reservationList){
            if(id==session.getSessionId()&&num.getHall()==hall && num.getRow()==row && num.getPlace()==place){
                throw new ReservationException("The seat you have chosen is occupied");
            }
        }
    }
    private static void generateRowAndPlace(int row, int place) throws ReservationException {
        if (row > 0 && row <= 5) {
            if(place > 0 && place <= 5){
            }else {
                throw new ReservationException("You have chosen the wrong place ");
            }
        } else {
            throw new ReservationException("You have chosen the wrong row");
        }
    }


}
