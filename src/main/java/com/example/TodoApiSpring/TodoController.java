package com.example.TodoApiSpring;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public  class TodoController {


    private static List<Todo> todos;


    public TodoController() {
        todos = new ArrayList<>();
        todos.add(new Todo(1, false, "Todo 1", 1));
        todos.add(new Todo(2, true, "Todo 2", 2));
        todos.add(new Todo(3, true, "Todo 3", 3));

    }

    @GetMapping("/Todos")

    public ResponseEntity <List<Todo>> getTodos() {
        return ResponseEntity.ok(todos);
    }

    @PostMapping("/Todos")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo) {

        todos.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);


    }

    @PostMapping("/AddMultipleTodo")
    public ArrayList<Todo> createMultipleTodo(@RequestBody ArrayList<Todo> newTodos) {
        todos.addAll(newTodos);
        return newTodos;


    }
}





