package com.cinema.kinoteatr.repository;

import com.cinema.kinoteatr.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema,Long> {
    boolean existsCinemaById(Long id);
}
