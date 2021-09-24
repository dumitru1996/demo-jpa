package com.tryjpa.demojpa.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTask(){
        return taskRepository.findAll();
    }

    public void addTask(@RequestBody Task task){
        taskRepository.save(task);
    }

    public void deleteTask(Integer taskId) {
        boolean exists = taskRepository.existsById(taskId);
        if(!exists){
            throw  new IllegalStateException(
                    String.format("Task with id %d does not exists",taskId));
        }
        taskRepository.deleteById(taskId);
    }
}
