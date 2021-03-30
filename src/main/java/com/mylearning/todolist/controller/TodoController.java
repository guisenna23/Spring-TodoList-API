package com.mylearning.todolist.controller;

import com.mylearning.todolist.model.TodoItem;
import com.mylearning.todolist.repo.TodoItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private  TodoItems repository;

    @GetMapping
    public List<TodoItem> listAllTodos(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TodoItem> listSpecificTodo(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping
    public TodoItem createTodo(@RequestBody @Valid TodoItem todoItem) {
        return repository.save(todoItem);
    }

}
