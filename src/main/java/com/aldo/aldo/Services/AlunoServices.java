package com.aldo.aldo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aldo.aldo.Model.Aluno;
import com.aldo.aldo.Repository.AlunoRepository;

@Component
public class AlunoServices {
    @Autowired
    AlunoRepository repository;

    public List<Aluno> findall(){
        return repository.findAll();
    }
    public Aluno findById(Integer id){
        Optional<Aluno> aluno = repository.findById(id);
        return aluno.get();
    }
    public Aluno insert(Aluno aluno){
        return repository.save(aluno);
    }
    public void delete(Integer id){
        repository.deleteById(id);
    }
    public Aluno update(Integer id, Aluno objeto){
        Aluno aluno = repository.getReferenceById(id);
        updateData(aluno, objeto);
        return repository.save(aluno);

    }
    public void updateData(Aluno aluno, Aluno objeto){
        aluno.setNome(objeto.getNome());
        aluno.setEndereco(objeto.getEndereco());
        aluno.setRa(objeto.getRa());
    }

}
