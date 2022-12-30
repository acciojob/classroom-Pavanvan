package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Repository
@Component
public class StudentRepository {
    HashMap<String,Student> studentHashMap=new HashMap<>();
    HashMap<Teacher, List<String>> teacherHashMap=new HashMap<>();
    public void addingStudentToDB(Student student) {
        //***********************
        studentHashMap.put(student.getName(),student);
    }

    public void addingTeacherToDB(Teacher teacher) {
        //***********************
        List<String> list=new ArrayList<>();
        teacherHashMap.put(teacher,list);
    }

    public void addingStudentTeacherPairToDB(String student, String teacher) {
        for(Teacher teacher1:teacherHashMap.keySet()){
            if(Objects.equals(teacher,teacher1.getName())){
                ////////////*********************************************
                List<String> list;
                list=teacherHashMap.get(teacher1);
                list.add(student);
                //teacher1.setNumberOfStudents(teacher1.getNumberOfStudents()+1);
                teacherHashMap.put(teacher1,list);
                return;
            }
            //******************************************
        }
    }

    public Student gettingStudentByNameFromDB(String name) {
        return studentHashMap.get(name);
    }

    public Teacher gettingTeacherByNameFromDB(String name) {
        for (Teacher teacher:teacherHashMap.keySet()){
            if (Objects.equals(name,teacher.getName())){
                return teacher;
            }
        }
        return null;
    }

    public List<String> gettingStudentsByTeacherNameFromDB(String teacher) {
        for(Teacher teacher1:teacherHashMap.keySet()){
            if(Objects.equals(teacher,teacher1.getName())){
                return teacherHashMap.get(teacher1);
            }
        }
        return null;
    }

    public List<String> gettingAllStudentsFromDB() {
        List<String> list=new ArrayList<>();
        list.addAll(studentHashMap.keySet());
        return list;
    }
    //need to check this
    public void deletingTeacherByNameFromDB(String teacher) {
        for (Teacher teacher1:teacherHashMap.keySet()){
            if(Objects.equals(teacher,teacher1.getName())){
                List<String> temp=teacherHashMap.get(teacher1);
                for(String str:temp){
                    studentHashMap.remove(str);
                }
                teacherHashMap.remove(teacher1);
                return;
            }
        }
    }

    public void deletingAllTeachersFromDB() {
        for (List<String> str:teacherHashMap.values()){
            List<String> temp=str;
            for(String str1:temp){
                studentHashMap.remove(str1);
            }
        }
        teacherHashMap.clear();
    }
}