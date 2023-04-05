package com.cinema.service.session;


import com.cinema.exceptions.exception.CinemaException;
import com.cinema.exceptions.exception.SessionException;
import com.cinema.model.Session;

import java.util.List;

public interface SessionService {
    List<Session> getSessions();
    Session createSession(Long movie_Id) throws SessionException;

    Session getSessionById(Long id) throws CinemaException;

    boolean deleteSession(Long id);
}
