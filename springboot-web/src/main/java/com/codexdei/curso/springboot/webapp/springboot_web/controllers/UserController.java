package com.codexdei.curso.springboot.webapp.springboot_web.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.codexdei.curso.springboot.webapp.springboot_web.models.User;

@Controller
public class UserController {

    //esta anotacion hace que este método se ejecute cuando alguien abre http://localhost:8080/details.
    @GetMapping("/details")
    //Model permite pasar datos del controlador(que es esta clase por la anotacion @Controller) a la vista
    public String details(Model model){

        User user = new User("Yorking", "Master");


        user.setEmail("yorking@celest.sion");
        model.addAttribute("title", "Hello World!!");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model){

        model.addAttribute("title","Users list");
       // users.forEach(u -> System.out.println(u));

        return "list";
    }

    @ModelAttribute("users")
    public List<User> usersModel(){
        return Arrays.asList(
                new User("Marye", "Mor"),
                new User("Samy", "Tequi", "samy@email.com"),
                new User("Yorking", "Master"),
                new User("Xto", "Emanuel", "xto@celest.sion")
        );
    }
}
