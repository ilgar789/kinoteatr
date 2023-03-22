package com.cinema.controller;


import com.cinema.dto.ReservationRequestDTO;
import com.cinema.model.Reservation;
import com.cinema.exception.ReservationException;
import com.cinema.service.reservation.ReservationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationServiceImpl reservationService;

    @GetMapping("/movie/session/reservation")
    public List<Reservation>getReservations(){
        return reservationService.getReservations();
    }

    @PostMapping("/movie/session/reservation/add/{id}")
    public boolean createReservation(@PathVariable(value = "id") Long id,@RequestBody ReservationRequestDTO reservationRequestDTO)
            throws ReservationException {

        return reservationService.createReservation(id,reservationRequestDTO);
    }

    @GetMapping("/movie/session/reservation/{id}")
    public Optional<Reservation> getReservationById(@PathVariable(value = "id") Long id)
            throws ReservationException {

        return reservationService.getReservationById(id);
    }
}