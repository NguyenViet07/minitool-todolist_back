package com.example.todolist.Repository;

import com.example.todolist.Model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findAllByNameContaining(String name);
    @Query("select s from ToDo s order by s.createDate desc")
    Iterable<ToDo> findOrOrderByCreateDate();
    @Query("select s from ToDo s order by s.rank desc ")
    Iterable<ToDo> findOrOrderByRank();

}
