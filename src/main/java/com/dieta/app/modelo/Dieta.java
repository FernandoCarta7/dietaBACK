package com.dieta.app.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table (name = "dieta")
public class Dieta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_dieta;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private String objetivo;
    private String recomendaciones;
    private String descripcion;
    private String categoria;
    private int calorias;

}
