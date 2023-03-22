package com.cinema.controller;


import com.cinema.model.Session;
import com.cinema.service.session.SessionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Boolean> createSession(@PathVariable("id") Long id)   {
        return ResponseEntity.ok(sessionService.createSession(id));

    }

}
