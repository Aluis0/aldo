package com.aldo.aldo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aldo.aldo.model.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer> {
    
}
