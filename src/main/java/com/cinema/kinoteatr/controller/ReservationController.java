package com.cinema.kinoteatr.controller;

import com.cinema.kinoteatr.dto.CinemaRequestDTO;
import com.cinema.kinoteatr.dto.ReservationRequestDTO;
import com.cinema.kinoteatr.exception.ReservationException;
import com.cinema.kinoteatr.model.Cinema;
import com.cinema.kinoteatr.model.Reservation;
import com.cinema.kinoteatr.service.reservation.ReservationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.naming.ldap.PagedResultsControl;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationServiceImpl reservationService;

    @GetMapping("/movie/session/reservation")
    public List<Reservation>getReservations(){
        return reservationService.getReservations();
    }

    @PostMapping("/movie/session/reservation/add")
    public boolean createReservation(@RequestBody ReservationRequestDTO reservationRequestDTO) throws ReservationException {

        return reservationService.createReservation(reservationRequestDTO);

    }
}
