package com.tryjpa.demojpa.tasks;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Task {

    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )@GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    private Integer taskId;
    private String taskName;
    private String taskDescription;
    private boolean completed;

    public Task(String taskName, String taskDescription, boolean completed) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.completed = completed;
    }
}
