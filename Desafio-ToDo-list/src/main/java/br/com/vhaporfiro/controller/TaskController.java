package br.com.vhaporfiro.controller;

import br.com.vhaporfiro.entities.Task;
import br.com.vhaporfiro.service.TaskService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping()
    public List<Task> getAllTask() {
        return taskService.getAllTask();
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Task> getById(@PathVariable("Id") Long Id) {
        Optional<Task> task = taskService.getById(Id);

        if (task.isPresent()) {
            return ResponseEntity.ok(task.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}