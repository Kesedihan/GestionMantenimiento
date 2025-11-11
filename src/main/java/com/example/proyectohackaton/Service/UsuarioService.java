package com.example.proyectohackaton.Service;

import com.example.proyectohackaton.Entity.Usuario;
import com.example.proyectohackaton.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Obtiene todos los usuarios activos
     */
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    /**
     * Obtiene un usuario por su ID
     */
    public Optional<Usuario> obtenerUsuarioPorId(Long idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    /**
     * Obtiene un usuario por su correo
     */
    public Optional<Usuario> obtenerUsuarioPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    /**
     * Crea un nuevo usuario
     */
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Actualiza un usuario existente
     */
    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Elimina un usuario por su ID
     */
    public void eliminarUsuario(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    /**
     * Valida las credenciales de un usuario
     */
    public boolean validarCredenciales(String correo, String contrasena) {
        Optional<Usuario> usuario = usuarioRepository.findByCorreo(correo);
        if (usuario.isPresent()) {
            return usuario.get().getContrasena().equals(contrasena);
        }
        return false;
    }
}
