package com.cinema.service.session;


import com.cinema.exceptions.cinema.CinemaException;
import com.cinema.exceptions.session.SessionException;
import com.cinema.model.Session;
import com.cinema.repository.CinemaRepository;
import com.cinema.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;
    private final CinemaRepository cinemaRepository;
    @Override
    public List<Session> getSessions() {
        return sessionRepository.findAll();
    }

    @Override
    public Session createSession(Long id) throws SessionException {
        if (null == cinemaRepository.findAllById(id)) {
            throw new SessionException("Movie with this id doesnt exists");
        } else {
            Session session = new Session();
            session.setDate(createSessionDate());
            session.setCinema(cinemaRepository.findById(id).get());
            sessionRepository.save(session);
            return sessionRepository.save(session);
        }
    }
    @Override
    public Session getSessionById(Long id) throws CinemaException {
        if (sessionRepository.getSessionsById(id).getId() != null) {
            return sessionRepository.getSessionsById(id);
        } else {
            throw new CinemaException("Session not found with this id ");
        }
    }
    @Override
    public boolean deleteSession(Long id) {
        if (sessionRepository.findById(id).isPresent()) {
            sessionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private Date createSessionDate() {

        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR, date.getHours() + 1);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.DAY_OF_MONTH, date.getDay() + 4);

        return calendar.getTime();
    }

}


