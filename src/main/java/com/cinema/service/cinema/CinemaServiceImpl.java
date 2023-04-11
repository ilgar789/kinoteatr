package com.cinema.service.cinema;


import com.cinema.dto.CinemaRequestDTO;
import com.cinema.model.Cinema;
import com.cinema.exceptions.cinema.CinemaException;
import com.cinema.repository.CinemaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
            throw new CinemaException("Movie not found with this id ");
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
        cinema.setMovie(cinemaDTO.getMovie());
        return cinemaRepository.save(cinema);
    }


}





















