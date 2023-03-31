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
import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequiredArgsConstructor
public class CinemaController {
    private final CinemaServiceImpl cinemaServiceImpl;

    @GetMapping("/cinema/{id}")
    public Optional<Cinema> getCardById(@PathVariable(value = "id") Long id) throws CinemaException {

        return cinemaServiceImpl.getCinemaById(id);
    }

    @PostMapping("/cinema/add")
    public ResponseEntity<Boolean> createUser(@RequestBody CinemaRequestDTO cinemaRequestDTO)
            throws CinemaException {
        return ResponseEntity.ok(cinemaServiceImpl.createCinema(cinemaRequestDTO));

    }
    @DeleteMapping("/cinema/delete/{id}")
    public boolean deleteMovie(@PathVariable("id") Long id)
            throws CinemaException {
        return cinemaServiceImpl.deleteMovie(id);

    }
    @PutMapping("/cinema/update/{id}")
    public Cinema updateMovie(@PathVariable("id") Long id, @RequestBody CinemaRequestDTO cinemaRequestDTO) {

        return cinemaServiceImpl.updateMovie(id, cinemaRequestDTO);

    }

    @GetMapping("/cinemas")
    public Model cinemaList(Model model) {

       return model.addAttribute("getCinemas", cinemaServiceImpl.getCinemas());

    }

}
