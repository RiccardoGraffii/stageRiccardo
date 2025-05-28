package com.example.springboottutorial.repository;

import com.example.springboottutorial.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudenteRepository extends JpaRepository<Studente, Integer> {
}
