package com.koushal.todolistapplication.Controller.todoController;

import com.koushal.todolistapplication.Data.TodoTask;
import com.koushal.todolistapplication.Services.AuthenticationService;
import com.koushal.todolistapplication.Services.TodoService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;


@Controller
public class TodoController {

    private final Logger logger= LoggerFactory.getLogger(getClass());
    AuthenticationService authenticationService;
    TodoService todoService;

    public TodoController(AuthenticationService authenticationService, TodoService todoService) {
        this.authenticationService = authenticationService;
        this.todoService=todoService;
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String postLogin(@RequestParam String name,@RequestParam String password,ModelMap model){
        if(authenticationService.authenticateUser(name,password)){
            model.put("name",name);
            return "redirect:list-todos";
        }
        //it will redirect to /login
        return "redirect:login";
    }

    @RequestMapping(value = "/list-todos")
    public String welcomePage(ModelMap model){
        model.put("todos",todoService.getTodoTask());
        return "welcome";
    }

    @RequestMapping(value = "/todo",method = RequestMethod.GET)
    public String addNewTodo(ModelMap modelMap){
        //This is for two way binding because when we go to this end point we are going to todo page which need all this attribute
        TodoTask todoTask=new TodoTask(0,"","",true, LocalDate.now().plusYears(10));
        modelMap.put("todo",todoTask);
        return "todo";
    }

    @RequestMapping(value = "/todo",method = RequestMethod.POST)
    //here @Valid annotation is used because then only spring will validate the object injected according to that validation given in attribute of TodoTask class
    //BindingResult class is used to check after validation if there is any error or not in that so, if there is error then we will handled case according
    //otherwise spring directly display error page.
    public String goToTodoDetailsPage(@Valid TodoTask todo, BindingResult result){
        if(result.hasErrors()) return "redirect:todo";
        todoService.addNewTodo(todo.getUsername(),todo.getDescription());
        return "redirect:list-todos";
    }

}
