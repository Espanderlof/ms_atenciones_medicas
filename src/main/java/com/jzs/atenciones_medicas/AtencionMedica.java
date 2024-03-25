package com.jzs.atenciones_medicas;

import java.time.LocalDateTime;

public class AtencionMedica {
    private int id;
    private LocalDateTime fecha;
    private String centro_salud;
    private String detalle_atencion;
    private Paciente paciente;

    public AtencionMedica (int id, LocalDateTime fecha, String centro_salud, String detalle_atencion, Paciente paciente){
        this.id = id;
        this.fecha = fecha;
        this.centro_salud = centro_salud;
        this.detalle_atencion = detalle_atencion;
        this.paciente = paciente;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }    

    public String getCentroSalud() {
        return centro_salud;
    }

    public String getDetalleatencion() {
        return detalle_atencion;
    }

    public Paciente getPaciente() {
        return paciente;
    }
}
