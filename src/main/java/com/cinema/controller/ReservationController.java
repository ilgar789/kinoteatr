package com.cinema.controller;


import com.cinema.dto.ReservationRequestDTO;
import com.cinema.model.Reservation;
import com.cinema.exception.ReservationException;
import com.cinema.service.reservation.ReservationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationServiceImpl reservationService;

    @PostMapping("/movie/session/{idS}/reservation/add/{idU}")
    public boolean createReservation(@PathVariable(value = "idS") Long idS,
                                     @PathVariable(value = "idU") Long idU,
                                     @RequestBody ReservationRequestDTO reservationRequestDTO)
            throws ReservationException {

        return reservationService.createReservation(idS,idU,reservationRequestDTO);
    }

    @GetMapping("/movie/session/reservation/{id}")
    public Optional<Reservation> getReservationById(@PathVariable(value = "id") Long id)
            throws ReservationException {

        return reservationService.getReservationById(id);
    }


    @GetMapping("/admin/reservations")
    public Model reservationsListAdmin(Model model) {

        return model.addAttribute("getReservations", reservationService.getReservations());

    }
    @PostMapping("/admin/reservations")
    public String  deleteReservations(@RequestParam(required = true, defaultValue = "" ) Long id,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            reservationService.deleteReservation(id);
        }
        return "redirect:/admin/reservations";
    }
}
