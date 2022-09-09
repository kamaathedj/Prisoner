package com.example.prisoner.repository;

import com.example.prisoner.models.Prisoner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrisonerRepository  extends JpaRepository<Prisoner,Long> {
}
