package com.cinema.service.reservation;


import com.cinema.dto.ReservationRequestDTO;
import com.cinema.model.Reservation;
import com.cinema.exception.ReservationException;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    List<Reservation> getReservations();

    boolean createReservation(Long idS,Long idU, ReservationRequestDTO reservationRequestDTO) throws ReservationException;

    Optional<Reservation> getReservationById(Long id) throws ReservationException;
}
