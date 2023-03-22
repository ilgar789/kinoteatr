package com.cinema.repository;


import com.cinema.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema,Long> {
    boolean existsCinemaById(Long id);
    boolean existsCinemaByMovie(String movie);
}