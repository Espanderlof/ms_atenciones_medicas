package com.jzs.atenciones_medicas;

import java.time.LocalDate;
import java.util.List;

public class Paciente {
    private String rut;
    private String nombre;
    private String direccion;
    private LocalDate fecha_nacimiento;
    private List<HistorialMedico> historialesMedicos; 

    public Paciente(String rut, String nombre, String direccion, LocalDate fecha_nacimiento, List<HistorialMedico> historialesMedicos) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento;
        this.historialesMedicos = historialesMedicos;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fecha_nacimiento;
    }

    public List<HistorialMedico> getHistorialMedico(){
        return historialesMedicos;
    }
}
