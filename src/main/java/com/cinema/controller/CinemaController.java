package com.cinema.controller;


import com.cinema.dto.CinemaRequestDTO;
import com.cinema.model.Cinema;
import com.cinema.exception.CinemaException;
import com.cinema.service.cinema.CinemaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RestController
@RequiredArgsConstructor
public class CinemaController {
    private final CinemaServiceImpl cinemaServiceImpl;

    @GetMapping("/movie/{id}")
    public Optional<Cinema> getCinemaById(@PathVariable(value = "id") Long id) throws CinemaException {
        return cinemaServiceImpl.getMovieById(id);
    }

    @PostMapping("/movie/add")
    public ResponseEntity<Boolean> createCinema(@RequestBody CinemaRequestDTO cinemaDTO)
            throws CinemaException {
        return ResponseEntity.ok(cinemaServiceImpl.createCinema(cinemaDTO));

    }
    @PutMapping("/movie/update/{id}")
    public Cinema updateMovie(@PathVariable("id") Long id, @RequestBody CinemaRequestDTO cinemaRequestDTO) {

        return cinemaServiceImpl.updateMovie(id, cinemaRequestDTO);

    }

    @GetMapping("/movies")
    public Model cinemaList(Model model) {
       return model.addAttribute("getCinemas", cinemaServiceImpl.getMovie());

    }
    @GetMapping("/admin/movie")
    public Model cinemaListAdmin(Model model) {
        return model.addAttribute("getCinemas", cinemaServiceImpl.getMovie());

    }

    @PostMapping("/admin/movie")
    public String deleteMovie(@RequestParam(required = true, defaultValue = "" ) Long id,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model)
            throws CinemaException {
        if (action.equals("delete")){
            cinemaServiceImpl.deleteMovie(id);
        }
        return "redirect:/admin/movie";

    }

}
