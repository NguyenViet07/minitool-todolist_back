package com.example.todolist.Service.impl;

import com.example.todolist.Model.ToDo;
import com.example.todolist.Repository.ToDoRepository;
import com.example.todolist.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements TodoService {
    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo findById(Long id) {
        Optional<ToDo> toDo = toDoRepository.findById(id);
        if (toDo.isPresent()){
            return toDo.get();
        }
        return null;
    }

    @Override
    public void save(ToDo todo) {
        toDoRepository.save(todo);
    }

    @Override
    public void delete(Long id) {
        Optional<ToDo> toDo = toDoRepository.findById(id);
        if (toDo.isPresent()){
            toDoRepository.delete(toDo.get());
        }
    }

    @Override
    public List<ToDo> findAllByNameContaining(String name) {
        return toDoRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<ToDo> findOrOrderByCreateDate() {
        return toDoRepository.findOrOrderByCreateDate();
    }

    @Override
    public Iterable<ToDo> findOrOrderByRank() {
        return toDoRepository.findOrOrderByRank();
    }
}
