package org.etiya.services.concretes;

import org.etiya.entities.concretes.Student;
import org.etiya.repositories.abstracts.StudentRepository;
import org.etiya.services.abstracts.StudentService;

import java.util.List;

public class StudentManager implements StudentService {

    private final StudentRepository studentRepository;

    public StudentManager(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void add(Student entity) {
        studentRepository.add(entity);
        System.out.println("Student eklendi.");
    }

    @Override
    public void update(Student entity) {
        studentRepository.update(entity);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public Student getById(int id) {
        return null;
    }

    @Override
    public Student getByName(String name) {
        return null;
    }
}
