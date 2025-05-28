package com.example.springboottutorial.controller;

import com.example.springboottutorial.model.Studente;
import com.example.springboottutorial.service.StudenteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/studenti")
public class StudenteController {

    private final StudenteService studenteService;

    public StudenteController(StudenteService studenteService) {
        this.studenteService = studenteService;
    }

    @GetMapping
    public List<Studente> getAll() {
        return studenteService.getAll();
    }

    @GetMapping("/{id}")
    public Studente getById(@PathVariable int id) {
        Studente studente = studenteService.getById(id);
        if (studente == null) {
            throw new RuntimeException("Studente non trovato");
        }
        return studente;
    }

    @PostMapping
    public Studente add(@RequestBody Studente studente) {
        return studenteService.add(studente);
    }

    @PutMapping("/{id}")
    public Studente update(@PathVariable int id, @RequestBody Studente updated) {
        Studente studente = studenteService.update(id, updated);
        if (studente == null) {
            throw new RuntimeException("Studente non trovato");
        }
        return studente;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studenteService.delete(id);
    }

    @RestController
    @RequestMapping("/api/test")
    public static class ControllerTest {

        private final StudenteService studenteService;

        public ControllerTest(StudenteService studenteService) {
            this.studenteService = studenteService;
        }

        @GetMapping("/lista")
        public List<Studente> listaStudenti() {
            return studenteService.getAll();
        }

        @PostMapping("/aggiungi")
        public Studente aggiungiStudente(@RequestBody Studente studente) {
            return studenteService.add(studente);
        }

        @DeleteMapping("/elimina/{id}")
        public void eliminaStudente(@PathVariable int id) {
            studenteService.delete(id);
        }
    }
}
