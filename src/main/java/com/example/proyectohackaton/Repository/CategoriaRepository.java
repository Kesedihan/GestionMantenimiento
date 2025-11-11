package com.example.proyectohackaton.Repository;

import com.example.proyectohackaton.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}