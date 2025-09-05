package com.example.todolist;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "todo_tasks")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_list")
    private Long Id;
    private String title;
    private String description;
    private Boolean completed;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Boolean isCompleted(){
        return completed;
    }
}
