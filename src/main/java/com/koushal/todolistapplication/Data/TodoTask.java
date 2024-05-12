package com.koushal.todolistapplication.Data;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity
public class TodoTask {

    @Id
    @GeneratedValue
    private long id;
    private String username;
    //here we have added a simple min length validation, like this we have many validations
    @Size(min = 10,message = "Enter at least 10 character")
    private String description;
    private String title;
    private boolean isDone;
    private LocalDate targetDate;

    public TodoTask(){}

    public TodoTask(long id, String username,String title, String description, boolean isDone,LocalDate target) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.isDone = isDone;
        this.targetDate=target;
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "TodoTask{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", isDone=" + isDone +
                ", targetDate=" + targetDate +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(boolean done) {
        isDone = done;
    }

}
