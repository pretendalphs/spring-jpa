package com.one.spring_jpa;

import com.one.spring_jpa.entities.Student;
import com.one.spring_jpa.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student student = new Student("John",
                    "Doe",
                    20,
                    "john@gmail.com");
            studentRepository.save(student);
            System.out.println(studentRepository.count());
            System.out.println(studentRepository.findById(1));
            System.out.println(studentRepository.existsById(1));
            System.out.println(studentRepository.findAll());
        };
    }
}
