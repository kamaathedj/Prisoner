package com.example.prisoner.services;


import com.example.prisoner.models.Prison;
import com.example.prisoner.repository.PrisonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrisonService {

    private final PrisonRepository repository;

    public PrisonService(PrisonRepository repository) {
        this.repository = repository;
    }

    public void reducePrisonCapacity(){
        Prison prison = repository.findAll().get(0);
        if(prison.getCapacity()>=1){
            prison.setCapacity(prison.getCapacity()-1);
        }else{
            throw new Error("no more prisoners");
        }

    }

    public List<Prison> getPrisons(){
        return repository.findAll();
    }
}
