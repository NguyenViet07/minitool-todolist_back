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
    @Query("select s from ToDo s where s.rank = -1 ")
    Iterable<ToDo> findByRankEqualsLow();
    @Query("select s from ToDo s where s.rank = 0 ")
    Iterable<ToDo> findByRankEqualsMedium();
    @Query("select s from ToDo s where s.rank = 1 ")
    Iterable<ToDo> findByRankEqualsHigh();

}
