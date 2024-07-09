package com.dieta.app.servicio;

import com.dieta.app.modelo.Nutricionista;

import java.util.List;

public interface INutricionistaServicio {
    public List<Nutricionista> listarNutricionistas();

    public Nutricionista buscarNutricionistaPorId(Integer idNutricionista);

    public Nutricionista guardarNutricionista(Nutricionista nutricionista);

    public void eliminarNutricionistaPorId(Integer idNutricionista);
}
