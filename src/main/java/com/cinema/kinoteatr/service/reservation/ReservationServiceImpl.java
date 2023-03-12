package com.cinema.kinoteatr.service.reservation;

import com.cinema.kinoteatr.model.Reservation;
import com.cinema.kinoteatr.model.Session;
import com.cinema.kinoteatr.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{
    private final ReservationRepository reservationRepository;
    public List<Reservation> getReservations(){
        return reservationRepository.findAll();
    }
}
