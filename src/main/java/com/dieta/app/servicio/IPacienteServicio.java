package com.dieta.app.servicio;

import com.dieta.app.modelo.Paciente;

import java.util.List;

public interface IPacienteServicio {
    public List<Paciente> listarPacientes();

    public Paciente buscarPacientePorId(Integer idPaciente);

    public Paciente guardarPaciente(Paciente paciente);

    public void eliminarPacientePorId(Integer idPaciente);
}
