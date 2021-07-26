package com.st.Demo.service;

import com.st.Demo.data.StudentRepository;
import com.st.Demo.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



import java.util.Optional;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }



    public ResponseEntity<Object> getStudent(long id) {
        return new ResponseEntity<>(studentRepository.findById(id), HttpStatus.OK);

    }

    public ResponseEntity<Object> getStudents(){
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Object> createStudent(Student student){
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());

        if(studentByEmail.isPresent())
            return new ResponseEntity<>("{\"message\":\"already created\"}", HttpStatus.BAD_REQUEST);
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is already this email saved before");

        studentRepository.save(student);
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }


    public ResponseEntity<Object> deleteStudent(long id) {
        Optional<Student>studentById = studentRepository.findById(id);
        if(studentById.isPresent()) {
            studentRepository.deleteById(id);
            return new ResponseEntity<>(id + "was deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>(id + " does not exist", HttpStatus.NOT_FOUND);
    }
}
