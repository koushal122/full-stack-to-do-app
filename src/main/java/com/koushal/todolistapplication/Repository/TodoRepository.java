package com.koushal.todolistapplication.Repository;

import com.koushal.todolistapplication.Data.TodoTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoTask,Integer> {

    public List<TodoTask> findByUsername(String username);
}
