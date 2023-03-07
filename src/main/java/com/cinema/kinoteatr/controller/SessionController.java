package com.cinema.kinoteatr.controller;

import com.cinema.kinoteatr.model.Cinema;
import com.cinema.kinoteatr.model.Session;
import com.cinema.kinoteatr.service.session.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @GetMapping("/sessions")
    public List<Session> getSessions(){
        return sessionService.getSessions();
    }

}
