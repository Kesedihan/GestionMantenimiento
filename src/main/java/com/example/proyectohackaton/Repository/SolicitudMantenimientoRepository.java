package com.example.proyectohackaton.Repository;

import com.example.proyectohackaton.Entity.SolicitudMantenimiento;
import com.example.proyectohackaton.Entity.Usuario;
import com.example.proyectohackaton.Entity.EstadoSolicitud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitudMantenimientoRepository extends JpaRepository<SolicitudMantenimiento, Long> {
    List<SolicitudMantenimiento> findByUsuario(Usuario usuario);
    // Buscar por estado usando el enum de la entidad
    List<SolicitudMantenimiento> findByEstadoSolicitud(EstadoSolicitud estadoSolicitud);
}