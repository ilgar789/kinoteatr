package com.cinema.service.cinema;


import com.cinema.dto.CinemaRequestDTO;
import com.cinema.model.Cinema;
import com.cinema.exception.CinemaException;

import java.util.List;
import java.util.Optional;

public interface CinemaService {

    List<Cinema> getCinemas();

    Optional<Cinema> getCinemaById(Long id) throws CinemaException;

    boolean createCinema(CinemaRequestDTO cinema) throws CinemaException;

    boolean deleteMovie(Long id) throws CinemaException;

    Cinema updateMovie(Long id, CinemaRequestDTO cinemaRequestDTO);
}
