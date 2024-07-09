package com.dieta.app.servicio;

import com.dieta.app.modelo.Alimento;

import java.util.List;

public interface IAlimentoServicio {

    public List<Alimento> listarAlimentos();

    //Implementar de ser necesario
    //public Alimento buscarAlimentoID();

    public Alimento guardarAlimento(Alimento alimento);

    public  void eliminarAlimentoID(Integer idAlimento);
}
