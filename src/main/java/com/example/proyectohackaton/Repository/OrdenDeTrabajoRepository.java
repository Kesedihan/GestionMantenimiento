package com.example.proyectohackaton.Repository;

import com.example.proyectohackaton.Entity.EstadoOrdenTrabajo;
import com.example.proyectohackaton.Entity.OrdenDeTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositorio para gestionar las órdenes de trabajo.
 */

public interface OrdenDeTrabajoRepository extends JpaRepository<OrdenDeTrabajo,Long> {
    /**
     * Busca órdenes por estado (ASIGNADA, EN_PROCESO, FINALIZADA).
     */
    List<OrdenDeTrabajo> findByEstado(EstadoOrdenTrabajo estado);
}