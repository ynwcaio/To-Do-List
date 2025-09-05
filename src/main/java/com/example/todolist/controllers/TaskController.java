package com.example.todolist.controllers;


import com.example.todolist.Tasks;
import com.example.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/todolist")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Tasks> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tasks> getTasksById(@PathVariable Long id) {
        Optional<Tasks> task = taskRepository.findById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tasks> createTask(@RequestBody Tasks tasks) {
        Tasks savedTasks = taskRepository.save(tasks);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTasks);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tasks> updateTask(@PathVariable Long id, @RequestBody Tasks taskDetail) {
        Optional<Tasks> tasks = taskRepository.findById(id);
        if (tasks.isPresent()) {
            Tasks existingTask = tasks.get();
            existingTask.setTitle(taskDetail.getTitle());
            existingTask.setDescription(taskDetail.getDescription());
            existingTask.setCompleted(taskDetail.isCompleted());

            Tasks updatedTask = taskRepository.save(existingTask);
            return ResponseEntity.ok(updatedTask);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
