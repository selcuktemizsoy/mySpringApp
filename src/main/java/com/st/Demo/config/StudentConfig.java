package com.st.Demo.config;

import com.st.Demo.data.StudentRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class StudentConfig {

        @Bean
        CommandLineRunner commandLineRunner(StudentRepository studentRepository){
            return args -> {
                studentRepository.saveAll(FakerGenerator.getRandomStudents(10));
            };
        }
}


