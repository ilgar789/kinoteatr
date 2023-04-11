package com.cinema.controller;

import com.cinema.exceptions.session.SessionException;
import com.cinema.model.Session;
import com.cinema.service.session.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @GetMapping("/session/{id}")
    public ResponseEntity<Session> getSessionById(@PathVariable(value = "id") Long id) throws SessionException {
        return ResponseEntity.ok(sessionService.getSessionById(id));
    }
    @PostMapping("/movie/{id}/session")
    public ResponseEntity<Session> createSession(@PathVariable("id") Long id) throws SessionException {
        return ResponseEntity.ok(sessionService.createSession(id));

    }

    @GetMapping("/sessions")
    public Model sessionsList(Model model) {
        return model.addAttribute("getSessions", sessionService.getSessions());

    }
    @GetMapping("/admin/sessions")
    public Model sessionsListAdmin(Model model) {
        return model.addAttribute("getSessions", sessionService.getSessions());

    }
    @PostMapping("/admin/sessions")
    public String  deleteSessions(@RequestParam(required = true, defaultValue = "" ) Long id,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            sessionService.deleteSession(id);
        }
        return "redirect:/admin/sessions";
    }
}
