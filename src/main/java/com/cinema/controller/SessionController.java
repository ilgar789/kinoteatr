package com.cinema.controller;

import com.cinema.model.Session;
import com.cinema.service.session.SessionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SessionController {

    private final SessionServiceImpl sessionService;

    @PostMapping("/movie/{id}/session")
    public ResponseEntity<Boolean> createSession(@PathVariable("id") Long id)   {
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
