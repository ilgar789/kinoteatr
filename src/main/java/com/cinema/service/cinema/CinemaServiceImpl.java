package com.cinema.service.cinema;


import com.cinema.dto.CinemaRequestDTO;
import com.cinema.model.Cinema;
import com.cinema.exceptions.exception.CinemaException;
import com.cinema.repository.CinemaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService {
    private final CinemaRepository cinemaRepository;

    @Override
    public List<Cinema> getMovie() {
        List<Cinema> list = cinemaRepository.findAll();
        return list;
    }

    @Override
    public Cinema getMovieById(Long id) throws CinemaException {
        Cinema cinema = cinemaRepository.findCinemaById(id);
        if (cinema != null) {
            return cinema;
        } else {
            throw new CinemaException("User not found with this id ");
        }
    }


    @Override
    public Cinema createMovie(CinemaRequestDTO cinemaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return cinemaRepository.save(modelMapper.map(cinemaDTO, Cinema.class));
    }

    @Override
    public boolean deleteMovie(Long id) throws CinemaException {
        if (cinemaRepository.findById(id).isPresent()) {
            cinemaRepository.deleteById(id);
            return true;
        } else {
            throw new CinemaException("This movie doesn't exist");
        }
    }

    @Override
    public Cinema updateMovie(Long id, CinemaRequestDTO cinemaDTO) {
        Cinema cinema = cinemaRepository.findById(id).get();
        cinema.setId(cinemaDTO.getId());
        cinema.setMovie(cinemaDTO.getMovie());
        return cinemaRepository.save(cinema);
    }


}





















