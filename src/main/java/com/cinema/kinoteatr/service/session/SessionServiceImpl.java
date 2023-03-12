package com.cinema.kinoteatr.service.session;

import com.cinema.kinoteatr.model.Cinema;
import com.cinema.kinoteatr.model.Session;
import com.cinema.kinoteatr.repository.CinemaRepository;
import com.cinema.kinoteatr.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService{

    private final SessionRepository sessionRepository;
    private final CinemaRepository cinemaRepository;
    @Override
    public List<Session> getSessions() {
        return sessionRepository.findAll();
    }

    @Override
    public boolean createSession(Long movie_Id)  {
        Cinema cinema = cinemaRepository.findById(movie_Id).get();
        Session session = new Session();
        session.setDate(createSessionDate());
        session.setCinema(cinema);
        sessionRepository.save(session);
        return true;
    }

    private Date createSessionDate()  {
        Date date=new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());

        calendar.set(Calendar.HOUR,date.getHours()+1);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        calendar.set(Calendar.DAY_OF_MONTH, date.getDay()+4);

        return calendar.getTime();
    }

    }


