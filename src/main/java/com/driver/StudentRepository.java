package com.driver;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
@Component
public class StudentRepository {
    private final Map<String, Student> studentMap = new HashMap<>();
    private final Map<Teacher, List<String>> teacherMap = new HashMap<>();

    public void addStudent(Student student) {
        studentMap.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher) {
        teacherMap.put(teacher, new ArrayList<>());
    }

    public void addStudentTeacherPair(String student, String teacher) {
        Teacher t = getTeacherByName(teacher);
        if (t == null) {
            return;
        }

        List<String> students = teacherMap.get(t);
        students.add(student);
        //t.setNumberOfStudents(t.getNumberOfStudents() + 1);
        teacherMap.put(t, students);
    }

    public Student getStudentByName(String name) {
        return studentMap.get(name);
    }

    public Teacher getTeacherByName(String name) {
        return teacherMap.keySet().stream()
                .filter(t -> t.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        Teacher t = getTeacherByName(teacher);
        return t == null ? null : teacherMap.get(t);
    }

    public List<String> getAllStudents() {
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacherByName(String teacher) {
        Teacher t = getTeacherByName(teacher);
        if (t == null) {
            return;
        }

        List<String> students = teacherMap.get(t);
        students.forEach(studentMap::remove);
        teacherMap.remove(t);
    }

    public void deleteAllTeachers() {
        teacherMap.values().forEach(students -> students.forEach(studentMap::remove));
        teacherMap.clear();
    }
}
