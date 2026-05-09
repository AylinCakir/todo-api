package com.example.todoapi.repository;

import com.example.todoapi.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<Task,Integer> {
}
