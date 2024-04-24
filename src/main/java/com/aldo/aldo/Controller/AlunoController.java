package com.aldo.aldo.Controller;

import java.net.URI;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aldo.aldo.Model.Aluno;
import com.aldo.aldo.Services.AlunoServices;

@RestController
@RequestMapping(value = "aluno")
public class AlunoController {
    @Autowired
    AlunoServices services;

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll(){
        List<Aluno> alunos = services.findall();
        return ResponseEntity.ok().body(alunos);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Integer id){
        Aluno aluno = services.findById(id);
        return ResponseEntity.ok().body(aluno);
    }
    @PostMapping
    public ResponseEntity<Aluno> insert(@RequestBody Aluno aluno){
        Aluno objeto = services.insert(aluno);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objeto.getId()).toUri();
        return ResponseEntity.created(uri).body(objeto);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        services.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Integer id, @RequestBody Aluno aluno){
        Aluno objeto = services.update(id, aluno);
        return ResponseEntity.ok().body(aluno);
    }
}
