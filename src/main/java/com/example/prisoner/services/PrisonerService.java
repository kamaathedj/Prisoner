package com.example.prisoner.services;

import com.example.prisoner.models.Prisoner;
import com.example.prisoner.models.PrisonerStuff;
import com.example.prisoner.repository.PrisonerRepository;
import com.example.prisoner.repository.PrisonerStuffRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PrisonerService {
    private final PrisonerRepository repository;
    private final PrisonerStuffRepository stuffRepository;
    private final PrisonService service;
    private final Logger L = LoggerFactory.getLogger(PrisonerService.class);


    public PrisonerService(PrisonerRepository repository, PrisonerStuffRepository stuffRepository, PrisonService service) {
        this.repository = repository;
        this.stuffRepository = stuffRepository;
        this.service = service;
    }

    public List<Prisoner> getAllPrisoners(){
        return repository.findAll();
    }

    public Prisoner getPrisonerById(Long id) throws Error{
        return repository.getById(id);

    }
    @Transactional
    public  void addPrisoner(Prisoner prisoner){
        System.out.println(prisoner.getSid());
        PrisonerStuff stuff = stuffRepository.save(prisoner.getSid());
        Prisoner prisoner1 = new Prisoner(prisoner.getName(),prisoner.getPrisonedWhen(),stuff);
        repository.save(prisoner1);
        service.reducePrisonCapacity();
    }
}
