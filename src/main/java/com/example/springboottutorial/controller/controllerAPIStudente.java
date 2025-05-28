package com.example.springboottutorial.controller;

import com.example.springboottutorial.Model.StudenteModel;
import com.example.springboottutorial.service.StudenteService;
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
    public List<StudenteModel> getAll() {
        return studenteService.getAll();
    }

    @GetMapping("/{id}")
    public StudenteModel getById(@PathVariable int id) {
        StudenteModel studenteModel = studenteService.getById(id);
        if (studenteModel == null) {
            throw new RuntimeException("Studente non trovato");
        }
        return studenteModel;
    }

    @PostMapping
    public StudenteModel add(@RequestBody StudenteModel studenteModel) {
        return studenteService.add(studenteModel);
    }

    @PutMapping("/{id}")
    public StudenteModel update(@PathVariable int id, @RequestBody StudenteModel updated) {
        StudenteModel studenteModel = studenteService.update(id, updated);
        if (studenteModel == null) {
            throw new RuntimeException("Studente non trovato");
        }
        return studenteModel;
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
        public List<StudenteModel> listaStudenti() {
            return studenteService.getAll();
        }

        @PostMapping("/aggiungi")
        public StudenteModel aggiungiStudente(@RequestBody StudenteModel studenteModel) {
            return studenteService.add(studenteModel);
        }

        @DeleteMapping("/elimina/{id}")
        public void eliminaStudente(@PathVariable int id) {
            studenteService.delete(id);
        }
    }
}
