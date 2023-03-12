package com.cinema.kinoteatr.controller;

import com.cinema.kinoteatr.model.Reservation;
import com.cinema.kinoteatr.service.reservation.ReservationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
