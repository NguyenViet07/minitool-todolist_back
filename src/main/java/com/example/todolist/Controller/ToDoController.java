package com.example.todolist.Controller;

import com.example.todolist.Model.ToDo;
import com.example.todolist.Service.TodoService;
import com.sun.tools.javac.comp.Todo;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
public class ToDoController {
    @Autowired
    private TodoService todoService;
    @GetMapping("/todos")
    public ResponseEntity<Iterable<ToDo>>listToDo(){
        Iterable<ToDo> toDos = todoService.findAll();
        return new ResponseEntity<>(toDos, HttpStatus.OK);
    }
    @GetMapping("/todos/{id}")
    public ResponseEntity<ToDo>detailTodo(@PathVariable Long id){
        ToDo toDo = todoService.findById(id);
        if (toDo == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(toDo, HttpStatus.OK);
    }
    @PostMapping("/todos")
    public ResponseEntity<Iterable<ToDo>>createToDo(@RequestBody ToDo todo){
        todoService.save(todo);
        Iterable<ToDo> toDos = todoService.findAll();
        return new ResponseEntity<>(toDos, HttpStatus.OK);
    }
    @DeleteMapping("todos/{id}")
    public ResponseEntity<Void>deleteToDo(@PathVariable Long id ){
        ToDo toDo = todoService.findById(id);
        if (toDo == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        todoService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @PutMapping("todos")
    public ResponseEntity<Void>updateSong(@RequestBody ToDo todo){
        todoService.save(todo);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
