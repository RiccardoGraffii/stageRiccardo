package com.example.springboottutorial.service;

import com.example.springboottutorial.Model.StudenteModel;
import com.example.springboottutorial.repository.StudenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudenteService {

    private final StudenteRepository studenteRepository;

    public StudenteService(StudenteRepository studenteRepository) {
        this.studenteRepository = studenteRepository;
    }

    public List<StudenteModel> getAll() {
        return studenteRepository.findAll();
    }

    public StudenteModel getById(int id) {
        return studenteRepository.findById(id).orElse(null);
    }

    public StudenteModel add(StudenteModel studenteModel) {
        return studenteRepository.save(studenteModel);
    }

    public StudenteModel update(int id, StudenteModel updated) {
        StudenteModel studenteModel = studenteRepository.findById(id).orElse(null);
        if (studenteModel != null) {
            studenteModel.setNome(updated.getNome());
            studenteModel.setCognome(updated.getCognome());
            return studenteRepository.save(studenteModel);
        }
        return null;
    }

    public void delete(int id) {
        studenteRepository.deleteById(id);
    }
}
