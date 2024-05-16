package com.aldo.aldo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aldo.aldo.model.Aluno;
import com.aldo.aldo.repository.AlunoRepository;

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
    public Aluno update(Integer id, Aluno aluno) {
        Aluno obj = findById(id);
        obj.setNome(aluno.getNome());
        obj.setIdade(aluno.getIdade());
        obj.setCurso(aluno.getCurso());
        obj.setMatricula(aluno.getMatricula());
        return repository.save(obj);
    }

}
