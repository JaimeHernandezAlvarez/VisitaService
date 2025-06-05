package com.servicio.visita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.servicio.visita.model.Visita;
import com.servicio.visita.service.VisitaService;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/visitas")
public class VisitaController {
    @Autowired
    private VisitaService visitaService;


    @GetMapping
    public ResponseEntity<List<Visita>> listar() {
        List<Visita> visitas = visitaService.findAll();
        if (visitas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(visitas);
    }

    @PostMapping()
    public ResponseEntity<Visita> guardar(@RequestBody Visita visita){
        Visita nuevo = visitaService.save(visita);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visita> buscar(@PathVariable Integer id) {
        try {
            Visita visita = visitaService.findById(id);
            return ResponseEntity.ok(visita);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Visita> actualizar(@PathVariable Integer id, @RequestBody Visita visita) {
        try {
            Visita existente = visitaService.findById(id);
            existente.setId(id);
            existente.setAsunto(visita.getAsunto());
            existente.setFecha(visita.getFecha());
            existente.setHora(visita.getHora());

            Visita actualizado = visitaService.save(existente);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            visitaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
