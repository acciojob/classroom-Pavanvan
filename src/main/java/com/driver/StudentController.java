package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add-student")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body("New student added successfully");
    }

    @PostMapping("/add-teacher")
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher) {
        studentService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body("New teacher added successfully");
    }

    @PutMapping("/add-student-teacher-pair")
    public ResponseEntity<String> addStudentTeacherPair(@RequestParam String student, @RequestParam String teacher) {
        studentService.addStudentTeacherPair(student, teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body("New student-teacher pair added successfully");
    }

    @GetMapping("/get-student-by-name/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable String name) {
        Student student = studentService.getStudentByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @GetMapping("/get-teacher-by-name/{name}")
    public ResponseEntity<Teacher> getTeacherByName(@PathVariable String name) {
        Teacher teacher = studentService.getTeacherByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(teacher);
    }

    @GetMapping("/get-students-by-teacher-name/{teacher}")
    public ResponseEntity<List<String>> getStudentsByTeacherName(@PathVariable String teacher) {
        List<String> students = studentService.getStudentsByTeacherName(teacher);
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/get-all-students")
    public ResponseEntity<List<String>> getAllStudents() {
        List<String> students = studentService.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @DeleteMapping("/delete-teacher-by-name")
    public ResponseEntity<String> deleteTeacherByName(@RequestParam String teacher) {
        studentService.deleteTeacherByName(teacher);
        return ResponseEntity.status(HttpStatus.OK).body(teacher + " removed successfully");
    }

    @DeleteMapping("/delete-all-teachers")
    public ResponseEntity<String> deleteAllTeachers() {
        studentService.deleteAllTeachers();
        return ResponseEntity.status(HttpStatus.OK).body("All teachers deleted successfully");
    }
}

