package com.julio.crudjulio.services;

import java.util.List;

import com.julio.crudjulio.dtos.CitaDto;
import com.julio.crudjulio.models.entities.Cita;

public interface CitaService {
    List<Cita> findAll();
    CitaDto createCita(CitaDto citaDto);
    void deteleCita(Long citaId);
    CitaDto updateCita(Long citaId, CitaDto citaDto);
    CitaDto logicalDeleteCita(Long citaId, CitaDto citaDto);
    CitaDto getCitaById(Long citaId);
}
