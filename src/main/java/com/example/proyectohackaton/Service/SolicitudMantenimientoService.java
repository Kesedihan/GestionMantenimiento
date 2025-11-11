package com.example.proyectohackaton.Service;

import com.example.proyectohackaton.Entity.SolicitudMantenimiento;
import com.example.proyectohackaton.Entity.Usuario;
import com.example.proyectohackaton.Repository.SolicitudMantenimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitudMantenimientoService {

    @Autowired
    private SolicitudMantenimientoRepository solicitudRepository;

    /**
     * Obtener todas las solicitudes de mantenimiento
     */
    public List<SolicitudMantenimiento> obtenerTodasLasSolicitudes() {
        return solicitudRepository.findAll();
    }

    /**
     * Obtener solicitud por ID
     */
    public Optional<SolicitudMantenimiento> obtenerSolicitudPorId(Long idSolicitud) {
        return solicitudRepository.findById(idSolicitud);
    }

    /**
     * Obtener solicitudes por usuario (solicitante)
     */
    public List<SolicitudMantenimiento> obtenerSolicitudesPorUsuario(Usuario usuario) {
        return solicitudRepository.findByUsuario(usuario);
    }

    /**
     * Crear una nueva solicitud de mantenimiento
     */
    public SolicitudMantenimiento crearSolicitud(SolicitudMantenimiento solicitud) {
        // Asignar fecha actual si no viene
        if (solicitud.getFechaSolicitud() == null) {
            solicitud.setFechaSolicitud(LocalDate.now());
        }
        
        // Si no se asignó estado, colocar PENDIENTE por defecto
        if (solicitud.getEstadoSolicitud() == null) {
            // Se asume que existe el enum PENDIENTE en EstadoSolicitud
            // solicitud.setEstadoSolicitud(EstadoSolicitud.PENDIENTE);
        }
        
        return solicitudRepository.save(solicitud);
    }

    /**
     * Actualizar una solicitud existente
     */
    public SolicitudMantenimiento actualizarSolicitud(SolicitudMantenimiento solicitud) {
        return solicitudRepository.save(solicitud);
    }

    /**
     * Eliminar una solicitud
     */
    public void eliminarSolicitud(Long idSolicitud) {
        solicitudRepository.deleteById(idSolicitud);
    }

    /**
     * Contar solicitudes por usuario
     */
    public long contarSolicitudesPorUsuario(Usuario usuario) {
        return solicitudRepository.findByUsuario(usuario).size();
    }
}
