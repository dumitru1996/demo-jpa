package com.tryjpa.demojpa.students;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.Month.APRIL;
import static java.time.Month.SEPTEMBER;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner1(
            StudentRepository repository){
        return args -> {
            Student boris = new Student(
                    1L,
                    "Boris",
                    "boris@mail.com",
                    LocalDate.of(2000, SEPTEMBER, 5)
            );
            Student dumitru = new Student(
                    "Dumitru",
                    "dumitru@mail.com",
                    LocalDate.of(1996, APRIL, 19)
            );
            List<Student> students = new ArrayList<>();
            students.add(boris);
            students.add(dumitru);
            repository.saveAll(
                    students
            );
        };
    }
}
