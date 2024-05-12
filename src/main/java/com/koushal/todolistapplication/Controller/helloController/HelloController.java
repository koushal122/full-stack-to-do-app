package com.koushal.todolistapplication.Controller.helloController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String getHello(){
        return "Hello! What are you learning today? ";
    }

    @RequestMapping("/hello-html")
    @ResponseBody
    public String getHelloHTML(){
        String reponse=
                """
                        <!DOCTYPE html>
                               <html lang="en">
                                   <head>
                                       <meta charset="UTF-8">
                                       <meta name="viewport" content="width=device-width, initial-scale=1.0">
                                       <title>Document</title>
                                   </head>
                                   <body>
                                       <h1>This is HTML response!</h1>
                                   </body>
                               </html>
                
                """;
        return reponse;
    }

    @RequestMapping("/hello-html-jsp")
    public String getHelloHTMLFromJSP(){
        return "sayHello";
    }

}
