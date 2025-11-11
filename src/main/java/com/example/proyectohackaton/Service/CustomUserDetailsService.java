package com.example.proyectohackaton.Service;

import com.example.proyectohackaton.Entity.Rol;
import com.example.proyectohackaton.Entity.Usuario;
import com.example.proyectohackaton.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Servicio que implementa UserDetailsService para integrar con Spring Security.
 * Carga usuarios por correo y convierte sus roles a GrantedAuthority.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(username);
        if (usuarioOpt.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }

        Usuario usuario = usuarioOpt.get();

        Set<GrantedAuthority> authorities = new HashSet<>();
        if (usuario.getRoles() != null) {
            for (Rol rol : usuario.getRoles()) {
                // Añadir prefijo ROLE_ para compatibilidad con Spring Security
                String roleName = "ROLE_" + rol.getNombre().name();
                authorities.add(new SimpleGrantedAuthority(roleName));
            }
        }

        // Construir UserDetails (username = correo, password = contrasena)
        return User.builder()
                .username(usuario.getCorreo())
                .password(usuario.getContrasena() == null ? "" : usuario.getContrasena())
                .disabled(!usuario.getActivo())
                .authorities(authorities)
                .build();
    }
}
