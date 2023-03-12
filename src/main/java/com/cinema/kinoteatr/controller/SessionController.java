package com.cinema.kinoteatr.controller;

import com.cinema.kinoteatr.model.Session;
import com.cinema.kinoteatr.service.session.SessionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SessionController {

    private final SessionServiceImpl sessionService;

    @GetMapping("/sessions")
    public List<Session> getSessions(){
        return sessionService.getSessions();
    }


    @PostMapping("/movie/{id}/session")
    public ResponseEntity<Boolean> createCard(@PathVariable("id") Long id)   {
        return ResponseEntity.ok(sessionService.createSession(id));

    }

}
