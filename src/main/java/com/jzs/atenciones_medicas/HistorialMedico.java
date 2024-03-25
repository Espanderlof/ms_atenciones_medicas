package com.jzs.atenciones_medicas;

import java.time.LocalDateTime;

public class HistorialMedico {
    private int id_historial;
    private LocalDateTime fecha_ingreso_historial;
    private String detalle_historial;

    public HistorialMedico (int id_historial, LocalDateTime fecha_ingreso_historial, String detalle_historial){
        this.id_historial = id_historial;
        this.fecha_ingreso_historial = fecha_ingreso_historial;
        this.detalle_historial = detalle_historial;
    }

    public int getIdHistorial(){
        return id_historial;
    }

    public LocalDateTime getFechaIngresoHistorial(){
        return fecha_ingreso_historial;
    }

    public String getDetalleHistorial(){
        return detalle_historial;
    }
}
