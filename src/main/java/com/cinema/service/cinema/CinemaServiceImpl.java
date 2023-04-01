package com.cinema.service.cinema;


import com.cinema.dto.CinemaRequestDTO;
import com.cinema.model.Cinema;
import com.cinema.exception.CinemaException;
import com.cinema.repository.CinemaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    public Optional<Cinema> getMovieById(Long id) throws CinemaException {
        Optional<Cinema> cinema = cinemaRepository.findById(id);
        if (cinema.isPresent()) {
            return Optional.of(cinema.orElseGet(Cinema::new));
        } else {
            throw new CinemaException("This cinema doesn't exist");
        }
    }

    @Override
    public boolean createCinema(CinemaRequestDTO cinemaDTO) throws CinemaException {
        if (cinemaRepository.existsCinemaById(cinemaDTO.getId())) {
            throw new CinemaException("This movie is not available");
        } else if (cinemaRepository.existsCinemaByMovie(cinemaDTO.getMovie())) {
            throw new CinemaException("This movie is not available");
        } else {
            ModelMapper modelMapper=new ModelMapper();
            cinemaRepository.save(modelMapper.map(cinemaDTO,Cinema.class));
        }
        return true;

    }

    @Override
    public boolean deleteMovie(Long id) throws CinemaException {
        if (cinemaRepository.findById(id).isPresent()) {
            cinemaRepository.deleteById(id);
            return true;
        }else {
            throw  new CinemaException("This movie doesn't exist");
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





















