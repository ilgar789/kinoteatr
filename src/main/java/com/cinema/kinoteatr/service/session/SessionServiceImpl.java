package com.cinema.kinoteatr.service.session;

import com.cinema.kinoteatr.model.Session;
import com.cinema.kinoteatr.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService{

    private final SessionRepository sessionRepository;
    @Override
    public List<Session> getSessions() {
        return sessionRepository.findAll();
    }
}
