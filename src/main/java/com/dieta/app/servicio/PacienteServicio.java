package com.dieta.app.servicio;

import com.dieta.app.modelo.Paciente;
import com.dieta.app.repositorio.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PacienteServicio implements IPacienteServicio{

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Override
    public List<Paciente> listarPacientes() {
        return this.pacienteRepositorio.findAll();
    }

    @Override
    public Paciente buscarPacientePorId(Integer idPaciente) {
        return this.pacienteRepositorio.findById(idPaciente).orElse(null);
    }

    @Override
    public Paciente guardarPaciente(Paciente paciente) {
        return this.pacienteRepositorio.save(paciente);
    }

    @Override
    public void eliminarPacientePorId(Integer idPaciente) {
        this.pacienteRepositorio.deleteById(idPaciente);
    }
}
