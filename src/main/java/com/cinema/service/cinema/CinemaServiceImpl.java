package com.cinema.service.cinema;


import com.cinema.dto.CinemaRequestDTO;
import com.cinema.model.Cinema;
import com.cinema.exception.CinemaException;
import com.cinema.repository.CinemaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService {
    private final CinemaRepository cinemaRepository;

    @Override
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
        if (cinemaRepository.existsCinemaById(cinema.getId())) {
            throw new CinemaException("This movie is not available");
        }else if(cinemaRepository.existsCinemaByMovie(cinema.getMovie())){
            throw new CinemaException("This movie is not available");
        }else {
            Cinema cinema1 = new Cinema();
            cinema1.setId(cinema.getId());
            cinema1.setMovie(cinema.getMovie());

            cinemaRepository.save(cinema1);

        }
        return true;

    }

    @Override
    public boolean deleteMovie(Long id) throws CinemaException {
        Optional<Cinema> cinema = cinemaRepository.findById(id);
        if (cinema.isPresent()) {
            cinemaRepository.deleteById(id);
            return true;
        } else {
            throw new CinemaException("This movie doesn't exist");
        }
    }

    @Override
    public Cinema updateMovie(Long id, CinemaRequestDTO cinemaRequestDTO) {
        Cinema cinema = cinemaRepository.findById(id).get();
        cinema.setId(cinemaRequestDTO.getId());
        cinema.setMovie(cinemaRequestDTO.getMovie());

        return cinemaRepository.save(cinema);
    }


}





















