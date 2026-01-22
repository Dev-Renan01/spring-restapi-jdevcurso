package com.devrenan.jdevcurso.controller;

import com.devrenan.jdevcurso.model.Usuario;
import com.devrenan.jdevcurso.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Usuario>index(){
        Usuario usuario = new Usuario();

        usuario.setNome("Thiago");
        usuario.setLogin("Thxxx");
        usuario.setSenha(1234);

        Usuario usuario1 = new Usuario();

        usuario1.setNome("Suany");
        usuario1.setLogin("Suxxx");
        usuario1.setSenha(1234);

        Usuario usuario2 = new Usuario();

        usuario2.setNome("Regis");
        usuario2.setLogin("Rexxx");
        usuario2.setSenha(1234);

        Usuario usuario3 = new Usuario();


        usuario3.setNome("Fabio");
        usuario3.setLogin("Faxxx");
        usuario3.setSenha(1234);

        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(usuario);
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        usuarioRepository.saveAll(usuarios);

        return usuarios;
    }
}