package com.example.prisoner.repository;

import com.example.prisoner.models.PrisonerStuff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrisonerStuffRepository extends JpaRepository<PrisonerStuff, Long> {
}
