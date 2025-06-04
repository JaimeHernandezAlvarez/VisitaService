package com.servicio.visita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicio.visita.model.Visita;
import com.servicio.visita.repository.VisitaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VisitaService {
    @Autowired
    private VisitaRepository visitaRepository;

    //Listar usuarios
    public List<Visita> findAll(){
        return visitaRepository.findAll();
    }

    //Listar usuario por ID
    public Visita findById(long id){
        return visitaRepository.findById(id).get();
    }

    //guardar usuario por ID
    public Visita save(Visita usuario){
        return visitaRepository.save(usuario);
    }

    //Eliminar usuario
    public void delete(long id){
        visitaRepository.deleteById(id);
    }
}
