package com.constructionxpert.tache_service.controller;

import com.constructionxpert.tache_service.exception.TaskNotFoundException;
import com.constructionxpert.tache_service.model.Task;
import com.constructionxpert.tache_service.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.ok(createdTask);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok( taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> getTaskById(@PathVariable Long id) throws TaskNotFoundException {
        Optional<Task> task = Optional.ofNullable(taskService.getTaskById(id));
        return ResponseEntity.ok(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) throws TaskNotFoundException {
        return ResponseEntity.ok( taskService.updateTask(id, taskDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Task>> getTasksByProjectId(@PathVariable Long projectId) throws TaskNotFoundException {
        return ResponseEntity.ok(taskService.getTasksByProjectId(projectId));
    }

    @GetMapping("/{id}/exists")
    public ResponseEntity<Boolean> existTask(@PathVariable("id") Long id) {
        boolean exists = taskService.existTask(id);
        return ResponseEntity.ok(exists);
    }
}
