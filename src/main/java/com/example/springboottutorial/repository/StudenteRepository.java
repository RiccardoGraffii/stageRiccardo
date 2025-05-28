package com.example.springboottutorial.repository;

import com.example.springboottutorial.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudenteRepository extends JpaRepository<Studente, Integer> {
    List<Studente> findByNome(String nome);
}
