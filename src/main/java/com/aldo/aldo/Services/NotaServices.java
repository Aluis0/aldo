package com.aldo.aldo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aldo.aldo.model.Nota;
import com.aldo.aldo.repository.NotaRepository;

@Component
public class NotaServices {
    @Autowired
    NotaRepository repository;

    public List<Nota> findall(){
        return repository.findAll();
    }
    public Nota findById(Integer id){
        Optional<Nota> Nota = repository.findById(id);
        return Nota.get();
    }
    public Nota insert(Nota nota){
        return repository.save(nota);
    }
    public void delete(Integer id){
        repository.deleteById(id);
    }
    public Nota update(Integer id, Nota nota) {
        Nota obj = findById(id);
        obj.setNome_disciplina(nota.getNome_disciplina());
        obj.setNota(nota.getNota());
        return repository.save(obj);
    }

}
