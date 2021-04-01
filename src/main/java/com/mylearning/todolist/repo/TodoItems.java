package com.mylearning.todolist.repo;

import com.mylearning.todolist.model.TodoItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItems extends MongoRepository<TodoItem,String> {

}
