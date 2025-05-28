package com.example.springboottutorial.controller;

import com.example.springboottutorial.model.Studente;
import com.example.springboottutorial.service.StudenteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/studenti")
public class StudenteController {


    private final StudenteService studenteService;

    public StudenteController(StudenteService studenteService) {
        this.studenteService = studenteService;
    }

    @GetMapping
    public List<Studente> getAll(@RequestParam(required = false) String nome) {

        if(nome == null){

            return studenteService.getAll();

        }else{
            List<Studente> studenti = studenteService.getByName(nome);
            if (studenti.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Studente non trovato");
            }
            return studenti;
        }

    }

    @GetMapping("/{id}")
    public Studente getById(@PathVariable int id) {
        return studenteService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Studente non trovato"));
    }




    @PostMapping
    public Studente add(@RequestBody Studente studente) {
        return studenteService.add(studente);
    }

    @PutMapping("/{id}")
    public Studente update(@PathVariable int id, @RequestBody Studente updated) {
        return studenteService.update(id, updated).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Studente non trovato"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        studenteService.delete(id);
    }
}
