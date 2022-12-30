package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class StudentService {
    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public void addStudent(Student student) {
        repository.addStudent(student);
    }

    public void addTeacher(Teacher teacher) {
        repository.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        repository.addStudentTeacherPair(student, teacher);
    }

    public Student getStudentByName(String name) {
        return repository.getStudentByName(name);
    }

    public Teacher getTeacherByName(String name) {
        return repository.getTeacherByName(name);
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return repository.getStudentsByTeacherName(teacher);
    }

    public List<String> getAllStudents() {
        return repository.getAllStudents();
    }

    public void deleteTeacherByName(String teacher) {
        repository.deleteTeacherByName(teacher);
    }

    public void deleteAllTeachers() {
        repository.deleteAllTeachers();
    }
}
