package com.codexdei.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codexdei.curso.springboot.webapp.springboot_web.models.User;
import com.codexdei.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.code}")
    private Integer code;

    @Value("${config.username}")
    private String username;
//  comentamos lo siguiente para agregarlo en el metodo 'values' directamente
  //@Value("${config.message}")
  //private String message;

    @Value("${config.listOfValues}")
    private String[] listOfValues;

    @GetMapping("/baz/{message}")
    //@PathVariable(name=mensaje) hace que se cambia el nombre de la variable, por lo cual tendria que cambiarse el
    //GetMapping a mensaje asi:
    //@GetMapping("/baz/{mensaje}"), pero lo habitual es no usarlo
    public ParamDto baz(@PathVariable /*(name = "mensaje")*/ String message){

        ParamDto param = new ParamDto();
        param.setMessage(message);

        return param;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String,Object> mixPathVar(@PathVariable String product, @PathVariable Integer id){

        Map<String,Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user){
        //hacer algo con el usuario guardado en la bbdd
        user.setName(user.getName().toUpperCase());
        return user;
    }

    @GetMapping("/values")
    public Map<String,Object> values(@Value("${config.message}") String message){

        Map<String,Object> json = new HashMap<>();
        json.put("code", code);
        json.put("username", username);
        json.put("message", message);
        json.put("listOfValues", listOfValues);

        return json;
    }
}
