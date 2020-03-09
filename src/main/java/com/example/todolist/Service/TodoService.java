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

}
