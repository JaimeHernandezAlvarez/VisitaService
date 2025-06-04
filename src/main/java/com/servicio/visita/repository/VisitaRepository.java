package com.servicio.visita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicio.visita.model.Visita;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, Long> {

}
