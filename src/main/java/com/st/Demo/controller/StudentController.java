package com.st.Demo.controller;


import com.st.Demo.model.Student;
import com.st.Demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @RequestMapping(path = "first/v1/student")
    public Student getStudent(){
        return studentService.getStudent();
    }


    @GetMapping
    @RequestMapping(path = "first/v1/allStudents")
    public List<Student> getListOfStudents(){
        System.out.println(studentService.getStudents());
        return studentService.getStudents();
    }

    @PostMapping
    @RequestMapping(path = "first/v1/create")
    public String createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return "vadaaa";
    }



}
