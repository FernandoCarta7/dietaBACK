package com.dieta.app.comparator;

import com.dieta.app.modelo.Paciente;

import java.util.Comparator;

public class PacienteComparator implements Comparator<Paciente> {
    @Override
    public int compare(Paciente o1, Paciente o2) {
        return o1.getPrimer_apellido().compareToIgnoreCase(o2.getPrimer_apellido());
    }
}
