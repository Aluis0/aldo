package com.aldo.aldo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aldo.aldo.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    
}
