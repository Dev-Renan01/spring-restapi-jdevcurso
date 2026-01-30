package com.devrenan.jdevcurso.controller;

import com.devrenan.jdevcurso.model.Telefone;
import com.devrenan.jdevcurso.service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TelefoneController {

    @Autowired
    private TelefoneService telefoneService;

    @GetMapping(value = "/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<Telefone> listar(){
        return telefoneService.listarTodos();
    }

    @GetMapping(value = "/listar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Telefone> listarId(@PathVariable Long id){
        return telefoneService.listarId(id);
    } 

    @PostMapping(value = "/salvar")
    @ResponseStatus(HttpStatus.OK)
    public Telefone salvar(@RequestBody Telefone telefone){
        return telefoneService.salvar(telefone);
    }

    @PutMapping(value = "/atualizar")
    @ResponseStatus(HttpStatus.OK)
    public Telefone atualizar(Telefone telefone){
        return telefoneService.atualizar(telefone);
    }

    @DeleteMapping(value = "/deletar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(Long id){
        telefoneService.deletar(id);
    }
}