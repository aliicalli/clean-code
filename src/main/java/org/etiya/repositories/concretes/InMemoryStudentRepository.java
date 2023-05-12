package org.etiya.repositories.concretes;

import org.etiya.entities.concretes.Student;
import org.etiya.repositories.abstracts.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStudentRepository implements StudentRepository {

    List<Student> studentList = new ArrayList<>();

    @Override
    public void add(Student entity) {
        studentList.add(entity);
    }

    @Override
    public void update(Student entity) {
        Student studentToUpdate = studentList
                .stream()
                .filter(student -> student.getId() == entity.getId())
                .findFirst()
                .orElse(null);
        studentList.removeIf(studentToUpdate::equals);
        studentToUpdate.setName(entity.getName());
        studentToUpdate.setAge(entity.getAge());
        studentToUpdate.setSurname(entity.getSurname());
        studentToUpdate.setNationalityId(entity.getNationalityId());
        studentToUpdate.setBooks(entity.getBooks());
        studentList.add(studentToUpdate);
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
        return studentList;
    }
}
