package com.example.TodoApiSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public  class TodoController {


    private static List<Todo> todos;


    public TodoController(){
        todos = new ArrayList<>();
        todos.add(new Todo(1 , false , "Todo 1"  ,1));
        todos.add(new Todo(2 , true , "Todo 2"  ,2));
        todos.add(new Todo(3 , true , "Todo 3"  ,3));

    }

    @GetMapping("/Todos")
    public List<Todo> getTodos(){
        return todos;
    }

    @PostMapping("/Todos")
    public Todo createTodo(@RequestBody Todo newTodo){

        todos.add(newTodo);
        return newTodo;


    }
    @PostMapping("/AddMultipleTodo")
    public ArrayList<Todo> createMultipleTodo(@RequestBody ArrayList <Todo> newTodos){
        todos.addAll(newTodos);
        return newTodos;
    }





    }






