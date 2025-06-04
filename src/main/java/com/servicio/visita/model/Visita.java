package com.servicio.visita.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "visita")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visita {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "visita_seq")
    @SequenceGenerator(name = "visita_seq", sequenceName = "SEQ_VISITA", allocationSize = 1)
    @Column(name = "id_visita")
    private Integer id;

    @Column(name = "fecha_visita", length = 20)
    private String fecha;

    @Column(name = "hora_visita")
    private String hora;

    @Column(name = "asunto")
    private String asunto;
}
