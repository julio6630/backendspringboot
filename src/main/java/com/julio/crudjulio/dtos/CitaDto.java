package com.julio.crudjulio.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CitaDto {
    private Long id;
    private Date fecha;
    private String paciente;
    private Long tipo;
    private String doctor;
    private String numero;
    private String hora;
    private Long estatus;
}
