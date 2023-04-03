package com.cinema.repository;


import com.cinema.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {
    Session getSessionsById(Long id);

}
