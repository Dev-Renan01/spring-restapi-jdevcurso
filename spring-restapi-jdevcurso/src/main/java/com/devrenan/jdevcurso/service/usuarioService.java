package com.devrenan.jdevcurso.service;

import com.devrenan.jdevcurso.model.Usuario;
import com.devrenan.jdevcurso.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class usuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> listarId(long id){
       return usuarioRepository.findById(id);
    }

    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Usuario usuario){

        if (usuario.getId() == null) {
            throw new RuntimeException("ID do usuário é obrigatório para atualização");
        }

        if(!usuarioRepository.existsById(usuario.getId())){
            throw new RuntimeException("Missão não encontrada");
        }

        return usuarioRepository.saveAndFlush(usuario);
    }

    public void deletar(Long id){
        if (id == null) {
            throw new RuntimeException("ID do usuário é obrigatório para atualização");
        }

        if(!usuarioRepository.existsById(id)){
            throw new RuntimeException("Missão não encontrada");
        }

        usuarioRepository.deleteById(id);
    }
}