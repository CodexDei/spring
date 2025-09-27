package com.codexdei.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codexdei.curso.springboot.webapp.springboot_web.models.User;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/* @Controller
 Escucha solicitudes HTTP (como /clientes, /productos/10).
Llama a la lógica de negocio (usando servicios inyectados con IoC).
Devuelve una respuesta:
Una vista (ej: archivo HTML, JSP, Thymeleaf).
O un modelo con datos que la vista mostrará.
 */
@RestController
@RequestMapping("/api")
public class UserRestController {

    //esta anotacion hace que este método se ejecute cuando alguien abre http://localhost:8080/details.
    //Lo siguiente es equivalente a @GetMapping("/details")
    //@RequestMapping(path = "details", method=RequestMethod.GET)
    @GetMapping("/details")
    public Map<String,Object> details(){

        User user = new User("Yorking", "Master");
        Map<String,Object> body = new HashMap<>();

        body.put("title", "Hello World!!");
        body.put("user", user);

        return body;
    }
}
