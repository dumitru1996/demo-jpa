package com.tryjpa.demojpa.tasks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TaskConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            TaskRepository repository){
        return args -> {
            Task project = new Task(
                    "Course Project",
                    "Finish Project in time",
                    false
            );

            Task sleep = new Task(
              "Sleep",
              "Sleep at least 8h",
              false
            );

            List<Task> tasks = new ArrayList<>();
            tasks.add(project);
            tasks.add(sleep);

            repository.saveAll(tasks);
        };
    }
}
