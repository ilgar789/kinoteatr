package com.cinema.kinoteatr.service.cinema;

import com.cinema.kinoteatr.dto.CinemaRequestDTO;
import com.cinema.kinoteatr.exception.CinemaException;
import com.cinema.kinoteatr.model.Cinema;

import java.util.List;
import java.util.Optional;

public interface CinemaService {

     List<Cinema> getCinemas();

     Optional<Cinema> getCinemaById(Long id) throws CinemaException;

     boolean createCinema(CinemaRequestDTO cinema) throws CinemaException;


}
