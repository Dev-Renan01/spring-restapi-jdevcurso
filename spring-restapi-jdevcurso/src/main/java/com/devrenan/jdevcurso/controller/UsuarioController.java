package com.devrenan.jdevcurso.controller;

import com.devrenan.jdevcurso.model.Usuario;
import com.devrenan.jdevcurso.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/salvar")
    @ResponseStatus(HttpStatus.OK)
    public Usuario salvar(@RequestBody Usuario usuario){
        return usuarioService.salvar(usuario);
    }

    @PostMapping(value = "/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> listar(){
        return usuarioService.listarTodos();
    }

    @PostMapping(value = "/listarid")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Usuario> listarId(long id){
        return usuarioService.listarId(id);
    }

    @PostMapping(value = "/atualizar")
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualizar(@RequestBody Usuario usuario){
        return usuarioService.atualizar(usuario);
    }

    @PostMapping(value = "/deletar")
    @ResponseStatus(HttpStatus.OK)
    public void deletarId(Long id){
        usuarioService.deletar(id);
    }
}