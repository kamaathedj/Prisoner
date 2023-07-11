package com.example.prisoner.models;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Getter
@Setter
@Data
@ToString
@NoArgsConstructor
@Entity(name = "prisoner")
@Table()
public class Prisoner {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long pid;

    String name;
    LocalDate prisonedWhen;

    @OneToOne(cascade = CascadeType.REMOVE ,orphanRemoval = true)
    @JoinColumn(name = "stuff_id")
    PrisonerStuff sid;



    public Prisoner(String name, LocalDate prisonedWhen,PrisonerStuff sid) {
        this.name = name;
        this.prisonedWhen = prisonedWhen;
        this.sid = sid;
    }


};





