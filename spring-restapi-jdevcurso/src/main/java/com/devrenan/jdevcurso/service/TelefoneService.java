package com.devrenan.jdevcurso.service;

import com.devrenan.jdevcurso.model.Telefone;
import com.devrenan.jdevcurso.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;


    public List<Telefone> listarTodos(){
        return telefoneRepository.findAll();
    }

    public Optional<Telefone> listarId(Long id){
        return telefoneRepository.findById(id);
    }

    public Telefone salvar(Telefone telefone){
        return telefoneRepository.save(telefone);
    }

    public Telefone atualizar(Telefone telefone){

        if (telefone.getId() == null) {
            throw new RuntimeException("ID do usuário é obrigatório para atualização");
        }

        if(!telefoneRepository.existsById(telefone.getId())){
            throw new RuntimeException("Missão não encontrada");
        }

        return telefoneRepository.saveAndFlush(telefone);
    }

    public void deletar(Long id){
        if (id == null) {
            throw new RuntimeException("ID do usuário é obrigatório para atualização");
        }

        if(!telefoneRepository.existsById(id)){
            throw new RuntimeException("Missão não encontrada");
        }

        telefoneRepository.deleteById(id);
    }
}