package org.etiya.repositories.concretes;

import org.etiya.entities.concretes.Student;
import org.etiya.repositories.abstracts.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStudentRepository implements StudentRepository {

    List<Student> studentList = new ArrayList<>();

    @Override
    public void add(Student entity) {

    }

    @Override
    public void update(Student entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Student getById(int id) {
        return null;
    }

    @Override
    public List<Student> getAll() {
        return null;
    }
}
