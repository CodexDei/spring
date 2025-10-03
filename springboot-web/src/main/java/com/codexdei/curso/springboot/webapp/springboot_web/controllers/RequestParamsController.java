package com.codexdei.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codexdei.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.codexdei.curso.springboot.webapp.springboot_web.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    //al colocar en el navegador: http://localhost:8080/api/params/foo?message=hola a todos
    //mostrara un json con ese mensaje, asi:
    /* {
    "message": "hola a todos"
    } */
    //required = por defecto es true, al estar true hace obligatorio que se tenga que colocar un mensaje, pero
    //si es false hace que no genere error y muestra el mensaje como null
    //defaultValue = sino se coloca un mensaje muestra el que asignemos por defecto
    //name = hace que se pueda cambiar el parametro por el nombre que asignemos, pero
    //el estandar es que se llame igual, por ello lo dejamos comentado solo para que sirva de explicacion
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hi people"/*, name = "mensaje"*/) String message){

        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code){

        ParamMixDto params = new ParamMixDto();
        params.setMessage(text);
        params.setCode(code);

        return params;
    }

    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request){

        Integer code = 0;

        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {
        }

        ParamMixDto params = new ParamMixDto();
        params.setCode(code);
        params.setMessage(request.getParameter("message"));
        return params;
    }

}
