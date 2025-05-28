package com.example.springboottutorial;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/studenti")
public class controllerAPIStudente {

    private final StudenteService studenteService;

    public controllerAPIStudente(StudenteService studenteService) {
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
}
