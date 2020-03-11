package com.example.todolist.Service;

import com.example.todolist.Model.ToDo;

import java.util.List;

public interface TodoService {
    // trả về 1 mảng
    List<ToDo> findAll();
    // trả về 1 đối tượng
    ToDo findById(Long id);
    void save(ToDo todo);
    void delete(Long id);
    List<ToDo> findAllByNameContaining(String name);
    Iterable<ToDo> findOrOrderByCreateDate();
    Iterable<ToDo> findOrOrderByRank();
    Iterable<ToDo> findByRankEqualsLow();
    Iterable<ToDo> findByRankEqualsMedium();
    Iterable<ToDo> findByRankEqualsHigh();


}
