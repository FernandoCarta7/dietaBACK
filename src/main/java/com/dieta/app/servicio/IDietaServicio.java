package com.dieta.app.servicio;

import com.dieta.app.modelo.Dieta;

import java.util.List;

public interface IDietaServicio {

    public List<Dieta> listarDietas();

    public Dieta buscarDietaPorId(Integer idDieta);

    public Dieta guardarDieta(Dieta dieta);

    public void eliminarDietaPorId(Integer idDieta);
    
}
