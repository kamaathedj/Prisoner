package com.example.prisoner.controller;

import com.example.prisoner.models.Prison;
import com.example.prisoner.services.PrisonService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@ResponseBody
public class PrisonController {
    private final PrisonService service;

    public PrisonController(PrisonService service) {
        this.service = service;
    }

    @GetMapping("/prison")
    public ResponseEntity<List<Prison>> getPrisons(){
        return ResponseEntity.ok(service.getPrisons());
    }
}
