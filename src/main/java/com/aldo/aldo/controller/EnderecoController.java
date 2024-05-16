package com.aldo.aldo.controller;

import java.net.URI;
import java.util.List;

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

import com.aldo.aldo.Services.EnderecoServices;
import com.aldo.aldo.model.Endereco;

@RestController
@RequestMapping(value = "endereco")
public class EnderecoController {
    @Autowired
    EnderecoServices services;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll(){
        List<Endereco> enderecos = services.findall();
        return ResponseEntity.ok().body(enderecos);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Integer id){
        Endereco endereco = services.findById(id);
        return ResponseEntity.ok().body(endereco);
    }
    @PostMapping
    public ResponseEntity<Endereco> insert(@RequestBody Endereco endereco){
        Endereco objeto = services.insert(endereco);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objeto.getId()).toUri();
        return ResponseEntity.created(uri).body(objeto);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        services.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Endereco> update(@PathVariable Integer id, @RequestBody Endereco endereco){
        Endereco objeto = services.update(id, endereco);
        return ResponseEntity.ok().body(objeto);
    }
}
