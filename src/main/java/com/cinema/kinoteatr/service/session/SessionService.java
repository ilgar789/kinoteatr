package com.cinema.kinoteatr.service.session;

import com.cinema.kinoteatr.model.Cinema;
import com.cinema.kinoteatr.model.Session;

import java.util.List;

public interface SessionService {
    List<Session> getSessions();


    boolean createSession(Long movie_Id);
}
