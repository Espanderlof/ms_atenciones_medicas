package com.jzs.atenciones_medicas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class AtencionMedicaController {
    private List<AtencionMedica> atencionMedica = new ArrayList<>();

    public AtencionMedicaController (){
        DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        atencionMedica.add(
            new AtencionMedica(
                1, 
                LocalDateTime.parse("2024-03-24 18:37:00", formatoFechaHora), 
                "Hospital Puerto Montt", 
                "Fuerte dolor en la zona abdominal.", 
                new Paciente(
                    "18259920-4", 
                    "Jaime Zapata", 
                    "Canal Sarmiento #6412, Puerto Montt", 
                    LocalDate.parse("1993-05-23", formatoFecha), 
                    Arrays.asList(
                        new HistorialMedico(
                            1, 
                            LocalDateTime.parse("2024-03-01 10:00:00", formatoFechaHora), 
                            "Consulta por alergia"
                        ),
                        new HistorialMedico(
                            2, 
                            LocalDateTime.parse("2024-03-15 14:30:00", formatoFechaHora), 
                            "Control de presión"
                        )
                    )
                )
            )
        );
        atencionMedica.add(
            new AtencionMedica(
                2, 
                LocalDateTime.parse("2024-03-25 09:15:00", formatoFechaHora), 
                "Clinica Los Andes", 
                "Revisión de vista", 
                new Paciente(
                    "17458963-7", 
                    "Carla Mora", 
                    "Av. Del Valle #345, Santiago", 
                    LocalDate.parse("1988-11-12", formatoFecha), 
                    Arrays.asList(
                        new HistorialMedico(
                            1, 
                            LocalDateTime.parse("2023-12-12 11:00:00", formatoFechaHora), 
                            "Examen de sangre"
                        ),
                        new HistorialMedico(
                            2, 
                            LocalDateTime.parse("2024-01-20 15:30:00", formatoFechaHora), 
                            "Consulta nutricional"
                        )
                    )
                )
            )
        );
        atencionMedica.add(
            new AtencionMedica(
                3, 
                LocalDateTime.parse("2024-04-02 16:45:00", formatoFechaHora), 
                "Hospital San José", 
                "Vacunación anual", 
                new Paciente(
                    "16543289-K", 
                    "Roberto Nuñez", 
                    "Pasaje Los Alerces #654, Concepción", 
                    LocalDate.parse("1975-07-28", formatoFecha), 
                    Arrays.asList(
                        new HistorialMedico(
                            1, 
                            LocalDateTime.parse("2024-02-23 10:30:00", formatoFechaHora), 
                            "Control de hipertensión"
                        )
                    )
                )
            )
        );
        atencionMedica.add(
            new AtencionMedica(
                4, 
                LocalDateTime.parse("2024-05-10 14:00:00", formatoFechaHora), 
                "Centro Médico Vitacura", 
                "Consulta dermatológica por acné", 
                new Paciente(
                    "19876543-2", 
                    "Sofía Castro", 
                    "Calle Los Presidentes #1001, La Serena", 
                    LocalDate.parse("2001-04-16", formatoFecha), 
                    Arrays.asList(
                        new HistorialMedico(
                            1, 
                            LocalDateTime.parse("2023-11-11 09:00:00", formatoFechaHora), 
                            "Revisión general"
                        ),
                        new HistorialMedico(
                            2, 
                            LocalDateTime.parse("2024-03-22 12:00:00", formatoFechaHora), 
                            "Consulta por ansiedad"
                        )
                    )
                )
            )
        );
        atencionMedica.add(
            new AtencionMedica(
                5, 
                LocalDateTime.parse("2024-06-20 08:30:00", formatoFechaHora), 
                "Hospital Clínico Universidad de Chile", 
                "Operación de apendicitis", 
                new Paciente(
                    "18765432-9", 
                    "Gonzalo Martínez", 
                    "Avenida Matta #233, Santiago", 
                    LocalDate.parse("1990-02-15", formatoFecha), 
                    Arrays.asList(
                        new HistorialMedico(
                            1, 
                            LocalDateTime.parse("2024-06-19 13:45:00", formatoFechaHora), 
                            "Preoperatorio"
                        )
                    )
                )
            )
        );
    }

    @GetMapping("/atenciones")
    public List<AtencionMedica> getAtencionMedicas() {
        return atencionMedica;
    }

    @GetMapping("/atenciones/{id}")
    public AtencionMedica getAtencionMedicaById(@PathVariable int id) {
        for (AtencionMedica atencion : atencionMedica) {
            if (atencion.getId() == id) {
                return atencion;
            }
        }
        return null;
    }    

    @GetMapping("/paciente/{rut}")
    public Paciente getPacienteByRut(@PathVariable String rut) {
        for (AtencionMedica atencion : atencionMedica) {
            if (atencion.getPaciente().getRut().equals(rut)) {
                return atencion.getPaciente();
            }
        }
        return null;
    }

    @GetMapping("/paciente/nacimiento/{fecha_busqueda}/{fecha}")
    public List<Paciente> getPacientesPorFechaNacimiento(@PathVariable String fecha_busqueda, @PathVariable String fecha) {
        LocalDate fechaComparacion = LocalDate.parse(fecha);
        return atencionMedica.stream()
            .map(AtencionMedica::getPaciente)
            .filter(paciente -> {
                LocalDate fechaNacimiento = paciente.getFechaNacimiento();
                if ("mayor".equals(fecha_busqueda)) {
                    return fechaNacimiento.isAfter(fechaComparacion) || fechaNacimiento.isEqual(fechaComparacion);
                } else if ("menor".equals(fecha_busqueda)) {
                    return fechaNacimiento.isBefore(fechaComparacion) || fechaNacimiento.isEqual(fechaComparacion);
                } else {
                    return false;
                }
            })
            .collect(Collectors.toList());
    }

}
