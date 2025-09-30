package com.codexdei.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codexdei.curso.springboot.webapp.springboot_web.models.User;
import com.codexdei.curso.springboot.webapp.springboot_web.models.dto.UserDto;

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

    @GetMapping("/details")
    public UserDto details(){

        User user = new User("Yorking", "Master");

        UserDto userDto = new UserDto();
        userDto.setUser(user);
        userDto.setTitle("Hello Wordl");

        return userDto;
    }

    //esta anotacion hace que este método se ejecute cuando alguien abre http://localhost:8080/details.
    //Lo siguiente es equivalente a:
    // @GetMapping("/details-map") @RequestMapping(path = "details", method=RequestMethod.GET)
    @GetMapping("/details-map")
    public Map<String,Object> detailsMap(){

        User user = new User("Yorking", "Master");
        Map<String,Object> body = new HashMap<>();

        body.put("title", "Hello World!!");
        body.put("user", user);

        return body;
    }

    @GetMapping("/list")
    public List<User> list(){

        
        User user = new User("Yorking", "Master");
        User user2 = new User("Legolas", "Mon");
        User user3 = new User("Ades", "Mon");

        List<User> users = Arrays.asList(user,user2,user3);
    /*    
        ArrayList users = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        userList.add(user3);
    */
        return users;
    }
}
