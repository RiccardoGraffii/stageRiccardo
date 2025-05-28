package com.example.springboottutorial;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudenteService {

    private final StudenteRepository studenteRepository;

    public StudenteService(StudenteRepository studenteRepository) {
        this.studenteRepository = studenteRepository;
    }

    public List<Studente> getAll() {
        return studenteRepository.findAll();
    }

    public Studente getById(int id) {
        return studenteRepository.findById(id).orElse(null);
    }

    public Studente add(Studente studente) {
        return studenteRepository.save(studente);
    }

    public Studente update(int id, Studente updated) {
        Studente studente = studenteRepository.findById(id).orElse(null);
        if (studente != null) {
            studente.setNome(updated.getNome());
            studente.setCognome(updated.getCognome());
            return studenteRepository.save(studente);
        }
        return null;
    }

    public void delete(int id) {
        studenteRepository.deleteById(id);
    }
}
