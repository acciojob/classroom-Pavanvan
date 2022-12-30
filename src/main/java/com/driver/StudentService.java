package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addingStudent(Student student) {
        studentRepository.addingStudentToDB(student);
    }

    public void addingTeacher(Teacher teacher) {
        studentRepository.addingTeacherToDB(teacher);
    }

    public void addingStudentTeacherPair(String student, String teacher) {
        studentRepository.addingStudentTeacherPairToDB(student,teacher);
    }

    public Student gettingStudentByName(String name) {
        return studentRepository.gettingStudentByNameFromDB(name);
    }

    public Teacher gettingTeacherByName(String name) {
        return studentRepository.gettingTeacherByNameFromDB(name);
    }

    public List<String> gettingStudentsByTeacherName(String teacher) {
        return studentRepository.gettingStudentsByTeacherNameFromDB(teacher);
    }

    public List<String> gettingAllStudents() {
        //****************************************
        return studentRepository.gettingAllStudentsFromDB();
    }

    public void deletingTeacherByName(String teacher) {
        //*******************************************
        studentRepository.deletingTeacherByNameFromDB(teacher);
    }

    public void deletingAllTeachers() {
        studentRepository.deletingAllTeachersFromDB();
    }
}//******************************************