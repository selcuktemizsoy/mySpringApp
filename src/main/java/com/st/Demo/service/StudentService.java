package com.st.Demo.service;

import com.st.Demo.data.StudentRepository;
import com.st.Demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }



    public Student getStudent() {
        return studentRepository.findAll().get(0);

    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void createStudent(Student student){
        studentRepository.save(student);
    }



}
