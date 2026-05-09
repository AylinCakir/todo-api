package com.example.todoapi.service;

import com.example.todoapi.models.Task;
import com.example.todoapi.repository.TodoRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoService {

    private final TodoRepo todoRepo;

    public TodoService(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    public List<Task> getTasks() {return todoRepo.findAll();}
    public void addTask(Task task) {
        task.setDone(false);
        task.setCreatedAt(LocalDateTime.now());
        todoRepo.save(task);
    }
    public void deleteTask(int id) {todoRepo.deleteById(id); }
    public void updateTask(int id, Task newTask) {
        Task existingTask = todoRepo.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        existingTask.setDescription(newTask.getDescription());
        existingTask.setUpdatedAt(LocalDateTime.now());
        todoRepo.save(existingTask);
    }
    public Task completed(int id) {
        Task completed =  todoRepo.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        completed.setDone(true);
        completed.setCompletedAt(LocalDateTime.now());
        return todoRepo.save(completed);
    }


}
