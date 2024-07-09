package com.dieta.app.repositorio;

import com.dieta.app.modelo.Nutricionista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutricionistaRepositorio extends JpaRepository<Nutricionista,Integer> {
}
