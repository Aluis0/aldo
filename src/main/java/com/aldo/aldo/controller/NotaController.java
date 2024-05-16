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

import com.aldo.aldo.Services.NotaServices;
import com.aldo.aldo.model.Nota;

@RestController
@RequestMapping(value = "nota")
public class NotaController {
    @Autowired
    NotaServices services;

    @GetMapping
    public ResponseEntity<List<Nota>> findAll(){
        List<Nota> nota = services.findall();
        return ResponseEntity.ok().body(nota);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Nota> findById(@PathVariable Integer id){
        Nota nota = services.findById(id);
        return ResponseEntity.ok().body(nota);
    }
    @PostMapping
    public ResponseEntity<Nota> insert(@RequestBody Nota nota){
        Nota objeto = services.insert(nota);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objeto.getId()).toUri();
        return ResponseEntity.created(uri).body(objeto);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        services.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Nota> update(@PathVariable Integer id, @RequestBody Nota nota){
        Nota objeto = services.update(id, nota);
        return ResponseEntity.ok().body(objeto);
    }
}
