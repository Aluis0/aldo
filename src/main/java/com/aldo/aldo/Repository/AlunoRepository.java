package com.aldo.aldo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aldo.aldo.Model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    
}
