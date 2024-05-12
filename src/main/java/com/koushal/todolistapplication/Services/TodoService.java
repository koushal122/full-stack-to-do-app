package com.koushal.todolistapplication.Services;

import com.koushal.todolistapplication.Data.TodoTask;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    List<TodoTask> todoTask;
    int cnt=4;

    public TodoService(){
        todoTask=new ArrayList<>();
        todoTask.add(new TodoTask(1,"Koushal","Need to Study Aws",false,LocalDate.now().plusYears(10)));
        todoTask.add(new TodoTask(2,"Koushal2","Need to Study Devops",false,LocalDate.now().plusYears(2)));
        todoTask.add(new TodoTask(3,"Koushal3","Need to Study Azure",false,LocalDate.now().plusMonths(1)));
        todoTask.add(new TodoTask(4,"Koushal4","Full stack developement",false,LocalDate.now().plusYears(10)));
    }

    public List<TodoTask> getTodoTask(){
        return todoTask;
    }

    public void addNewTodo(String name,String description){
        todoTask.add(new TodoTask(++cnt,name,description,false,LocalDate.now().plusYears(1)));
    }
}
