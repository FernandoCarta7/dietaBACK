package com.dieta.app.servicio;

import com.dieta.app.modelo.Dieta;
import com.dieta.app.repositorio.DietaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DietaServicio implements IDietaServicio{

    @Autowired
    private DietaRepositorio dietaRepositorio;

    @Override
    public List<Dieta> listarDietas() {
        return this.dietaRepositorio.findAll();
    }

    @Override
    public Dieta buscarDietaPorId(Integer idDieta) {
        return this.dietaRepositorio.findById(idDieta).orElse(null);
    }

    @Override
    public Dieta guardarDieta(Dieta dieta) {
        return this.dietaRepositorio.save(dieta);
    }

    @Override
    public void eliminarDietaPorId(Integer idDieta) {
        this.dietaRepositorio.deleteById(idDieta);
    }
}
