package com.example.prisoner.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "prison")
@Table()
public class Prison {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;
    String name;
    int capacity;

    public Prison( String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}
