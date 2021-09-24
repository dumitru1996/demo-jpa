package com.tryjpa.demojpa.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @GetMapping()
    public List<Task> getAllTask(){
        return taskService.getTask();
    }

    @PostMapping()
    public void addTask(@RequestBody Task task){
        taskService.addTask(task);
    }

    @DeleteMapping(path = "{taskId}")
    public void deleteTask(@PathVariable("taskId")int taskId){
        taskService.deleteTask(taskId);
    }
}
