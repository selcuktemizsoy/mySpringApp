package com.st.Demo.controller;


import com.st.Demo.model.Student;
import com.st.Demo.service.StudentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping(path = "first/v1/student" )
public class StudentController {


    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getStudent(@PathVariable("id") long id ){
        return studentService.getStudent(id);
    }


    @GetMapping(path = "/getAll")
    public ResponseEntity<Object> getListOfStudents(){
        return studentService.getStudents();
    }


    @PostMapping(path = "/create")
    public ResponseEntity<Object> createStudent(@RequestBody Student student){
        return  studentService.createStudent(student);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable("id") long id){
        return studentService.deleteStudent(id);
    }



}
