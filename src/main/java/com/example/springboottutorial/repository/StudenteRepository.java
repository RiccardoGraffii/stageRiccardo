package com.example.springboottutorial.repository;

import com.example.springboottutorial.Model.StudenteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudenteRepository extends JpaRepository<StudenteModel, Integer> {
}
