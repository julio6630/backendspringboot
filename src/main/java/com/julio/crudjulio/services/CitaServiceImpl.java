package com.julio.crudjulio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julio.crudjulio.dtos.CitaDto;
import com.julio.crudjulio.mappers.CitaMapper;
import com.julio.crudjulio.models.entities.Cita;
import com.julio.crudjulio.repositories.CitaRepository;

@Service
public class CitaServiceImpl implements CitaService{

    @Autowired
    private CitaRepository citaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Cita> findAll() {
        return (List<Cita>) citaRepository.findAll();
    }

    @Override
    public CitaDto createCita(CitaDto citaDto){
        Cita cita = CitaMapper.mapToCita(citaDto);
        Cita citaSaved = citaRepository.save(cita);
        return CitaMapper.mapToCitaDto(citaSaved);
    }    

    @Override
    public void deteleCita(Long citaId){
        if(citaRepository.findById(citaId).isPresent()) {
            citaRepository.deleteById(citaId);
        }
    }

    @Override
    public CitaDto updateCita(Long citaId, CitaDto citaDto) {
        Cita citaFinded = citaRepository.findById(citaId).get();

        if(citaFinded.getId() > 1){
            citaFinded.setFecha(citaDto.getFecha());
            citaFinded.setHora(citaDto.getHora());
            citaFinded.setNumero(citaDto.getNumero());
            citaFinded.setDoctor(citaDto.getDoctor());
            citaFinded.setPaciente(citaDto.getPaciente());
            citaFinded.setTipo(citaDto.getTipo());

            Cita citaSaved = citaRepository.save(citaFinded);
            return CitaMapper.mapToCitaDto(citaSaved);
        }
        
        return new CitaDto();
    }
    
    @Override
    public CitaDto logicalDeleteCita(Long citaId, CitaDto citaDto) {
        Cita citaFinded = citaRepository.findById(citaId).get();

        if(citaFinded.getId() > 1){
            citaFinded.setEstatus(citaDto.getEstatus());
            Cita citaSaved = citaRepository.save(citaFinded);
            return CitaMapper.mapToCitaDto(citaSaved);
        }
        
        return new CitaDto();
    }

    @Override
    public CitaDto getCitaById(Long citaId) {
        Cita citaFinded = citaRepository.findById(citaId).get();

        if(citaFinded.getId() > 1){
            return CitaMapper.mapToCitaDto(citaFinded);
        }

        return new CitaDto();
    }
}
