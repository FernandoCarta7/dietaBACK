package com.dieta.app.servicio;

import com.dieta.app.modelo.Alimento;
import com.dieta.app.repositorio.AlimentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlimentoServicio implements IAlimentoServicio{

    @Autowired
    private AlimentoRepositorio alimentoRepositorio;

    @Override
    public List<Alimento> listarAlimentos() {
        //AlimentoComparator comparator = new AlimentoComparator();
        List<Alimento> list = this.alimentoRepositorio.findAll();
        //list.sort(comparator);
        list.sort(( Alimento a, Alimento b) -> a.getCategoria().compareToIgnoreCase(b.getCategoria()));
        return list;
    }

    @Override
    public Alimento guardarAlimento(Alimento alimento) {
        return this.alimentoRepositorio.save(alimento);
    }

    @Override
    public void eliminarAlimentoID(Integer idAlimento) {
        this.alimentoRepositorio.deleteById(idAlimento);
    }
}
