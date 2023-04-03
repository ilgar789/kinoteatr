package com.cinema.controller;


import com.cinema.dto.CinemaRequestDTO;
import com.cinema.model.Cinema;
import com.cinema.exceptions.exception.CinemaException;
import com.cinema.service.cinema.CinemaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class CinemaController {

    private final CinemaServiceImpl cinemaServiceImpl;

    @GetMapping("/movie/{id}")
    public ResponseEntity<Cinema> getMovieById(@PathVariable(value = "id") Long id) throws CinemaException {
        return ResponseEntity.ok(cinemaServiceImpl.getMovieById(id));
    }

    @PostMapping("/movie/add")
    public ResponseEntity<Cinema> createMovie(@RequestBody @Valid CinemaRequestDTO cinemaDTO) {
        return new ResponseEntity<>(cinemaServiceImpl.createMovie(cinemaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/movie/update/{id}")
    public Cinema updateMovie(@PathVariable("id") Long id, @RequestBody CinemaRequestDTO cinemaRequestDTO) {

        return cinemaServiceImpl.updateMovie(id, cinemaRequestDTO);

    }

    @GetMapping("/movies")
    public Model movieList(Model model) {
        return model.addAttribute("getCinemas", cinemaServiceImpl.getMovie());

    }

    @GetMapping("/admin/movie")
    public Model movieListAdmin(Model model) {
        return model.addAttribute("getCinemas", cinemaServiceImpl.getMovie());

    }

    @PostMapping("/admin/movie")
    public String deleteMovie(@RequestParam(required = true, defaultValue = "") Long id,
                              @RequestParam(required = true, defaultValue = "") String action,
                              Model model)
            throws CinemaException {
        if (action.equals("delete")) {
            cinemaServiceImpl.deleteMovie(id);
        }
        return "redirect:/admin/movie";

    }

}
