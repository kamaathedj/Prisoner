package com.example.prisoner.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Table(name = "prisonerStuff")
@Entity
public class PrisonerStuff {

    @Id
    @GeneratedValue
    long id;
    String name;

    public PrisonerStuff( String name) {
        this.name = name;
    }

    public PrisonerStuff() {

    }
};


