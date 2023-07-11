package com.example.prisoner.controller;

import com.example.prisoner.models.Prisoner;
import com.example.prisoner.services.PrisonerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PrisonerController {
    Logger l = LoggerFactory.getLogger(Prisoner.class);

    private final ApplicationContext context;
    private final PrisonerService prisonerService;


    public PrisonerController( ApplicationContext context, PrisonerService prisonerService) {
        this.context = context;
        this.prisonerService = prisonerService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Prisoner>> prisoners(){
        return ResponseEntity.ok(prisonerService.getAllPrisoners());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prisoner> getPrisonerById( @PathVariable long id){
        System.out.println(id);
        Prisoner  p  =  prisonerService.getPrisonerById(id);
        l.info(p.toString());
        return ResponseEntity.ok(p);
    }

    @PostMapping("/")
    public void addPrisoner(@RequestBody Prisoner prisoner){
        prisonerService.addPrisoner(prisoner);
    }

    @GetMapping("/down")
    public void down(){
        AvailabilityChangeEvent.publish(this.context, LivenessState.BROKEN);
    }

    @GetMapping("/slow")
    public void slow() throws Exception{
        Thread.sleep(10_000);
    }
}
