package com.devrenan.jdevcurso.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @GetMapping(value = "/{nome}", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public String index(@RequestParam(name = "nome") String nome) {
        return "Olá, " + nome +" seja muito bem vindo(a) ao meu projeto!";
    }
}