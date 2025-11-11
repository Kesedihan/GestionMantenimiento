package com.example.proyectohackaton.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor     // Genera el constructor con los paremetros
@NoArgsConstructor      // Genera el constructor sin los parametros
@Builder                // Con esto, lombok implementa el patron de diseño Builder para construir objetos de esta clase
@Entity
@Table(name = "usuario")
public class Usuario {

    /** Identificador único del usuario */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    /** Nombre del usuario */
    @Column(nullable = false, length = 100)
    private String nombre;

    /** Apellido del usuario */
    @Column(nullable = false, length = 100)
    private String apellido;

    /** Corro electronico del usuario (unico) */
    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    /** Contraseña cifrada del usuario */
     @Column(nullable = false)
    private String contrasena;

    /** Número de teléfono opcional del usuario */
     @Column(length = 10)
    private String celular;

    /** Estado del usuario (Activo o inactivo) */
    @Column(nullable = false)
    @Builder.Default
    private Boolean activo = true;

    /** Descripcion del cargo del usuario */
    @Column(name = "descripcion_cargo", length = 255)
    private String descripcionCargo;

    // Relación N:M con Rol
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_rol",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    @Builder.Default
    private Set<Rol> roles = new HashSet<>();

}
