package br.com.vhaporfiro.controller;

import br.com.vhaporfiro.dto.TaskDto;
import br.com.vhaporfiro.entities.Task;
import br.com.vhaporfiro.service.TaskService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody @Valid TaskDto taskDto) {

        Task createdTask = taskService.createTask(taskDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable("Id") Long Id,
            @RequestBody @Valid TaskDto taskDto) {

        Task updatedTask = taskService.updateTask(Id, taskDto);

        if (updatedTask != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedTask);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("Id") Long Id) {

        taskService.deleteById(Id);

        return ResponseEntity.noContent().build();
    }

}