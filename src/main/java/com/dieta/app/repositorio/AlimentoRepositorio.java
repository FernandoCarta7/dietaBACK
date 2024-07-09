package com.dieta.app.repositorio;

import com.dieta.app.modelo.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentoRepositorio extends JpaRepository<Alimento,Integer> {
}
