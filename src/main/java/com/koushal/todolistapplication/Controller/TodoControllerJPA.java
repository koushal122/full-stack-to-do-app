package com.koushal.todolistapplication.Controller;

import com.koushal.todolistapplication.Data.TodoTask;
import com.koushal.todolistapplication.Repository.TodoRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;


@Controller
public class TodoControllerJPA {

    private final Logger logger= LoggerFactory.getLogger(getClass());
    TodoRepository todoRepository;

    public TodoControllerJPA(TodoRepository todoRepository) {
        this.todoRepository=todoRepository;
    }


    @RequestMapping(value = "/")
    public String postLogin(ModelMap model){
        return "redirect:list-todos";
    }


    @RequestMapping(value = "/list-todos")
    public String welcomePage(ModelMap model){
        model.put("todos",todoRepository.findByUsername(getLoggedInUserName()));
        model.put("name",getLoggedInUserName());
        return "welcome";
    }

    @RequestMapping(value = "/todo",method = RequestMethod.GET)
    public String addNewTodo(ModelMap modelMap){
        //This is for two way binding because when we go to this end point we are going to todo page which need all this attribute
        TodoTask todoTask=new TodoTask(0,getLoggedInUserName(),"","",true, LocalDate.now().plusYears(10));
        modelMap.put("todo",todoTask);
        return "todo";
    }

    @RequestMapping(value = "/todo",method = RequestMethod.POST)
    //here @Valid annotation is used because then only spring will validate the object injected according to that validation given in attribute of TodoTask class
    //BindingResult class is used to check after validation if there is any error or not in that so, if there is error then we will handled case according
    //otherwise spring directly display error page.
    public String goToTodoDetailsPage(@Valid TodoTask todo, BindingResult result){
        if(result.hasErrors()) return "redirect:todo";
        //todoService.addNewTodo(todo.getUsername(),todo.getDescription(),todo.getTargetDate());
        todoRepository.save(new TodoTask(1001,getLoggedInUserName(),todo.getTitle(),todo.getDescription(),false,todo.getTargetDate()));
        return "redirect:list-todos";
    }

    @RequestMapping(value = "/delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    //Used to get User Authentication related information form spring security.
    public String getLoggedInUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
