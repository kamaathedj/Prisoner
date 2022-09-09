package com.example.prisoner.repository;

import com.example.prisoner.models.Prison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrisonRepository extends JpaRepository<Prison,Long> {
}
