package com.mylearning.todolist.repo;

import com.mylearning.todolist.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItems extends JpaRepository<TodoItem, Long> {

}
