package com.cinema.service.session;


import com.cinema.model.Session;

import java.util.List;

public interface SessionService {
    List<Session> getSessions();
    boolean createSession(Long movie_Id);
}
