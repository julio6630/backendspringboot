package com.julio.crudjulio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.julio.crudjulio.dtos.CitaDto;
import com.julio.crudjulio.models.entities.Cita;
import com.julio.crudjulio.services.CitaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping("/citas")
    public List<Cita> list() {
        return citaService.findAll();
    }

    @PostMapping("/citas")
    public ResponseEntity<CitaDto> createCita(@RequestBody CitaDto citaDto){
        CitaDto savedCita = citaService.createCita(citaDto);
        return new ResponseEntity<>(savedCita, HttpStatus.CREATED);
    }

    @DeleteMapping("/citas/{id}")
    public ResponseEntity<String> deleteCita(@PathVariable("id") Long citaId){
        citaService.deteleCita(citaId);
        return ResponseEntity.ok("Cita eliminada");
    }

    @PutMapping("/citas/{id}")
    public ResponseEntity<CitaDto> updateCita(@PathVariable("id") Long citaId, @RequestBody CitaDto citaUpdated ){
        CitaDto citaDto = citaService.updateCita(citaId, citaUpdated);
        return ResponseEntity.ok(citaDto);
    }

    @PutMapping("/citas/logicalDelete/{id}")
    public ResponseEntity<CitaDto> logicalDelete(@PathVariable("id") Long citaId, @RequestBody CitaDto citaUpdated ){
        CitaDto citaDto = citaService.logicalDeleteCita(citaId, citaUpdated);
        return ResponseEntity.ok(citaDto);
    }

    @GetMapping("/citas/{id}")
    public ResponseEntity<CitaDto> getCitaById(@PathVariable("id") Long citaId){
        CitaDto citaDto = citaService.getCitaById(citaId);
        return ResponseEntity.ok(citaDto);
    }
}
