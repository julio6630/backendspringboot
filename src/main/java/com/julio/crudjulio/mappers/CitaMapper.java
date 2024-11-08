package com.julio.crudjulio.mappers;

import com.julio.crudjulio.dtos.CitaDto;
import com.julio.crudjulio.models.entities.Cita;

public class CitaMapper {

    public static CitaDto mapToCitaDto(Cita cita){
        return new CitaDto(
            cita.getId(),
            cita.getFecha(),
            cita.getPaciente(),
            cita.getTipo(),
            cita.getDoctor(),
            cita.getNumero(),
            cita.getHora(),
            cita.getEstatus()
        );
    }

    public static Cita mapToCita(CitaDto citaDto){
        return new Cita(
            citaDto.getId(),
            citaDto.getFecha(),
            citaDto.getPaciente(),
            citaDto.getTipo(),
            citaDto.getDoctor(),
            citaDto.getNumero(),
            citaDto.getHora(),
            citaDto.getEstatus()
        );
    }
}
