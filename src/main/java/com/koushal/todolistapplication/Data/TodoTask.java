package com.koushal.todolistapplication.Data;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class TodoTask {
    private long id;
    private String username;
    //here we have added a simple min length validation, like this we have many validations
    @Size(min = 10,message = "Enter at least 10 character")
    private String description;
    private boolean isDone;
    private LocalDate targetDate;

    public TodoTask(long id, String username, String description, boolean isDone,LocalDate target) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.isDone = isDone;
        this.targetDate=target;
    }

    @Override
    public String toString() {
        return "TodoTask{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", isDone=" + isDone + '\'' +
                ", targetDate=" + targetDate +
                '}';
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

    public void setDone(boolean done) {
        isDone = done;
    }

}
