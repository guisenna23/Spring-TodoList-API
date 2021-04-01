package com.mylearning.todolist.controller;

import com.mylearning.todolist.model.TodoItem;
import com.mylearning.todolist.repo.TodoItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoItems repository;

    @GetMapping
    public List<TodoItem> listAllTodos(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TodoItem> listSpecificTodo(@PathVariable String id){
        return repository.findById(id);
    }

    @PostMapping
    public TodoItem createTodo(@RequestBody @Valid TodoItem todoItem) {
        return repository.save(todoItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoItem> updateTodo(@RequestBody TodoItem todoItem, @PathVariable String id){
        if(repository.findById(todoItem.getId()).isPresent()){
            if(id.equals(todoItem.getId())){
                return  ResponseEntity.ok(repository.save(todoItem));
            }
            //user trying to update resource from another route
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable String id){
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
