package com.example.springboottutorial;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudenteRepository extends JpaRepository<Studente, Integer> {
}
