package com.st.Demo.config;

import com.github.javafaker.Faker;
import com.st.Demo.model.Student;

import java.util.ArrayList;
import java.util.List;

public class FakerGenerator {

    public static Student getRandomStudent(){
        Faker faker = new Faker();
        return new Student(faker.name().fullName(), faker.educator().university());
    }


    public static List<Student> getRandomStudents(int number){
        List<Student> listOfStudent = new ArrayList<>();


        for (int i = 0; i < number; i++) {
            listOfStudent.add(getRandomStudent());
        }

        return listOfStudent;
    }
}
