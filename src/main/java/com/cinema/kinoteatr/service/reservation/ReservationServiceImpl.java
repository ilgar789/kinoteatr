package com.cinema.kinoteatr.service.reservation;

import com.cinema.kinoteatr.dto.ReservationRequestDTO;
import com.cinema.kinoteatr.exception.ReservationException;
import com.cinema.kinoteatr.model.Reservation;
import com.cinema.kinoteatr.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{
    private final ReservationRepository reservationRepository;
    public List<Reservation> getReservations(){
        return reservationRepository.findAll();
    }
    public boolean createReservation(ReservationRequestDTO reservationRequestDTO) throws ReservationException {
        ReservationServiceImpl reservationService=new ReservationServiceImpl(reservationRepository);
        ReservationServiceImpl.generateHall(reservationRequestDTO.getHall());
        ReservationServiceImpl.generateRowAndPlace(reservationRequestDTO.getRow(), reservationRequestDTO.getPlace());
        reservationService.reservationExamination(reservationRequestDTO.getHall(),reservationRequestDTO.getRow(),reservationRequestDTO.getPlace());
        Reservation reservation=new Reservation();
        reservation.setHall(reservationRequestDTO.getHall());
        reservation.setRow(reservationRequestDTO.getRow());
        reservation.setPlace(reservationRequestDTO.getPlace());
        reservationRepository.save(reservation);
        return true;
    }

    private void reservationExamination(int hall, int row, int place) throws ReservationException {
        List<Reservation>reservationList=reservationRepository.findAll();
        for(Reservation num:reservationList){
            if(num.getHall()==hall && num.getRow()==row && num.getPlace()==place){
                throw new ReservationException("The seat you have chosen is occupied");
            }
        }
    }

    private static void generateHall(int hall) throws ReservationException {
        if (hall > 0 && hall <= 3) {
        } else {
            throw new ReservationException("You have chosen the wrong hall");
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
