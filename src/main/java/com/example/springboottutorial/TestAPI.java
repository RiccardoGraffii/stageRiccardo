package com.example.springboottutorial;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestAPI {

    private final StudenteService studenteService;

    public TestAPI(StudenteService studenteService) {
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