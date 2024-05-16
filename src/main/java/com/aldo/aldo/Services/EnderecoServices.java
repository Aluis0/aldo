package com.aldo.aldo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aldo.aldo.model.Endereco;
import com.aldo.aldo.repository.EnderecoRepository;

@Component
public class EnderecoServices {
    @Autowired
    EnderecoRepository repository;

    public List<Endereco> findall(){
        return repository.findAll();
    }
    public Endereco findById(Integer id){
        Optional<Endereco> Endereco = repository.findById(id);
        return Endereco.get();
    }
    public Endereco insert(Endereco Endereco){
        return repository.save(Endereco);
    }
    public void delete(Integer id){
        repository.deleteById(id);
    }
    public Endereco update(Integer id, Endereco endereco) {
        Endereco obj = findById(id);
        obj.setRua(endereco.getRua());
        obj.setCidade(endereco.getCidade());
        obj.setEstado(endereco.getEstado());
        obj.setCep(endereco.getCep());
        return repository.save(obj);
    }

}
