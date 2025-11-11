package com.example.proyectohackaton.Repository;

import com.example.proyectohackaton.Entity.EstadoSolicitud;
import com.example.proyectohackaton.Entity.SolicitudMantenimiento;
import com.example.proyectohackaton.Entity.TipoFalla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudMantenimientoRepository extends JpaRepository<SolicitudMantenimiento, Long> {


    /**
     * Busca solicitudes por su estado (PENDIENTE, EN_PROCESO, CERRADA).
     */
    List<SolicitudMantenimiento> findByEstadoSolicitud(EstadoSolicitud estado);

    /**
     * Busca solicitudes por tipo de falla (ELECTRICA, MECANICA, etc.).
     */
    List<SolicitudMantenimiento> findByTipoFalla(TipoFalla tipoFalla);
}