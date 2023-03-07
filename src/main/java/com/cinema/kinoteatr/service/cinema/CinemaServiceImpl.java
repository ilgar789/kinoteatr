package com.cinema.kinoteatr.service.cinema;

import com.cinema.kinoteatr.dto.CinemaRequestDTO;
import com.cinema.kinoteatr.exception.CinemaException;
import com.cinema.kinoteatr.model.Cinema;
import com.cinema.kinoteatr.repository.CinemaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService {
    private final CinemaRepository cinemaRepository;

    public List<Cinema> getCinemas(){
        List<Cinema>list=cinemaRepository.findAll();
        return list;
    }

    @Override
    public Optional<Cinema> getCinemaById(Long id) throws CinemaException {
        Optional<Cinema> cinema = cinemaRepository.findById(id);
        if (cinema.isPresent()) {
            return Optional.of(cinema.orElseGet(Cinema::new));
        } else {
            throw new CinemaException("This cinema doesn't exist");
        }
    }

    @Override
    public boolean createCinema(CinemaRequestDTO cinema) throws CinemaException {
        if (cinemaRepository.existsCinemaById(Long.valueOf(cinema.getMovie()))) {
            throw new CinemaException("This cinema is not available");
        } else {
            Cinema cinema1 = new Cinema();
            cinema1.setMovie(cinema.getMovie());

            cinemaRepository.save(cinema1);

        }
        return true;

    }



}





















