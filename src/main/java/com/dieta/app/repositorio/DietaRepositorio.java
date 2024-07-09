package com.dieta.app.repositorio;

import com.dieta.app.modelo.Dieta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietaRepositorio extends JpaRepository<Dieta,Integer> {
}
