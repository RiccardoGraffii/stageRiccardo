package com.example.springboottutorial.service;

import com.example.springboottutorial.model.Studente;
import com.example.springboottutorial.repository.StudenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudenteService {

    private final StudenteRepository studenteRepository;

    public StudenteService(StudenteRepository studenteRepository) {
        this.studenteRepository = studenteRepository;
    }

    public List<Studente> getAll() {
        return studenteRepository.findAll();
    }

    public Optional<Studente> getById(int id) {
        return studenteRepository.findById(id);
    }

    public List<Studente> getByName(String nome) {
        return studenteRepository.findByNome(nome);
    }

    public Studente add(Studente studente) {
        return studenteRepository.save(studente);
    }

    public Optional<Studente> update(int id, Studente updated) {
        return studenteRepository.findById(id)
                .map(studente -> {
                    studente.setNome(updated.getNome());
                    studente.setCognome(updated.getCognome());
                    return studenteRepository.save(studente);
                });
    }

    public void delete(int id) {
        studenteRepository.deleteById(id);
    }
}
