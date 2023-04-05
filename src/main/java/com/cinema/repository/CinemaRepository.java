package com.cinema.repository;


import com.cinema.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    Cinema findCinemaById(Long id);
    Cinema findAllById(Long id);
}
