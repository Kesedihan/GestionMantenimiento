package com.example.proyectohackaton.Service;

import com.example.proyectohackaton.Entity.Rol;
import com.example.proyectohackaton.Entity.NombreRol;
import com.example.proyectohackaton.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    /**
     * Obtiene todos los roles
     */
    public List<Rol> obtenerTodosLosRoles() {
        return rolRepository.findAll();
    }

    /**
     * Obtiene un rol por su ID
     */
    public Optional<Rol> obtenerRolPorId(Integer idRol) {
        return rolRepository.findById(idRol);
    }

    /**
     * Obtiene un rol por su nombre
     */
    public Optional<Rol> obtenerRolPorNombre(NombreRol nombre) {
        return rolRepository.findByNombre(nombre);
    }

    /**
     * Crea un nuevo rol
     */
    public Rol crearRol(Rol rol) {
        return rolRepository.save(rol);
    }

    /**
     * Actualiza un rol existente
     */
    public Rol actualizarRol(Rol rol) {
        return rolRepository.save(rol);
    }

    /**
     * Elimina un rol por su ID
     */
    public void eliminarRol(Integer idRol) {
        rolRepository.deleteById(idRol);
    }
}
