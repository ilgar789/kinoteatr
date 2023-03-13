package com.cinema.kinoteatr.service.reservation;

import com.cinema.kinoteatr.dto.ReservationRequestDTO;
import com.cinema.kinoteatr.exception.ReservationException;
import com.cinema.kinoteatr.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    List<Reservation> getReservations();

    boolean createReservation(Long id ,ReservationRequestDTO reservationRequestDTO) throws ReservationException;

    Optional<Reservation> getReservationById(Long id) throws ReservationException;
}
