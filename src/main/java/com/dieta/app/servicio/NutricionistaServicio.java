package com.dieta.app.servicio;

import com.dieta.app.modelo.Nutricionista;
import com.dieta.app.repositorio.NutricionistaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NutricionistaServicio implements INutricionistaServicio{

    @Autowired
    private NutricionistaRepositorio nutricionistaRepositorio;

    @Override
    public List<Nutricionista> listarNutricionistas() {
        return this.nutricionistaRepositorio.findAll();
    }

    @Override
    public Nutricionista buscarNutricionistaPorId(Integer idNutricionista) {
        return this.nutricionistaRepositorio.findById(idNutricionista).orElse(null);
    }

    @Override
    public Nutricionista guardarNutricionista(Nutricionista nutricionista) {
        return this.nutricionistaRepositorio.save(nutricionista);
    }

    @Override
    public void eliminarNutricionistaPorId(Integer idNutricionista) {
        this.nutricionistaRepositorio.deleteById(idNutricionista);
    }
}
