package com.codexdei.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    //esta anotacion hace que este método se ejecute cuando alguien abre http://localhost:8080/details.
    @GetMapping("/details")
    //Model permite pasar datos del controlador(que es esta clase por la anotacion @Controller) a la vista
    public String details(Model model){

        model.addAttribute("title", "Hello World!!");
        model.addAttribute("name", "Yorking");
        model.addAttribute("lastname", "Master");

        return "details";
    }
}
