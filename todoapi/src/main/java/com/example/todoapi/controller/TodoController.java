package com.example.todoapi.controller;

import com.example.todoapi.models.Task;
import com.example.todoapi.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Task> getAllTasks() { return todoService.getTasks(); }
    @PostMapping
    public void addTask(@Valid @RequestBody Task task) {
        todoService.addTask(task);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable  int id) {
        todoService.deleteTask(id);
    }
    @PutMapping("/{id}")
    public void updateTask(@PathVariable int id, @RequestBody Task task) { todoService.updateTask(id, task);}
    @PatchMapping("/{id}/complete")
    public Task complete(@PathVariable int id) {
        return todoService.completed(id);
    }
}
