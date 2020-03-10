package com.example.todolist.Model;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "ToDo")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Boolean status = false;
    private String description;
    private Byte rank;
    private LocalDateTime createDate;

    public Byte getRank() {
        return rank;
    }

    public void setRank(Byte rank) {
        this.rank = rank;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public ToDo() {
    }

    public ToDo( String name, Boolean status, String description, Byte rank, LocalDateTime createDate){
        this.name = name;
        this.status = status;
        this.description = description;
        this.rank = rank;
        this.createDate = createDate;

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
