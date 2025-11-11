package com.example.proyectohackaton.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Entidad que representa la ubicacion de cada equipo.
 *
 * @author Jorel
 * @version 1.0
 *
 */

@Data
@AllArgsConstructor     // Genera el constructor con los paremetros
@NoArgsConstructor      // Genera el constructor sin los parametros
@Builder                // Con esto, lombok implementa el patron de diseño Builder para construir objetos de esta clase
@Entity
@Table(name = "ubicacion")
public class Ubicacion {

    /** Identificador único de cada ubicacion */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ubicacion")
    private Long idUbicacion;


    /** Nombre de la ubicacion */
    @Column(nullable = false, length = 100)
    private String nombre;


    /** Descripcion de la ubicaccion del equipo */
    @Column(columnDefinition = "TEXT")
    private String descripcion;

    /** Indica si la ubicacion está activa (soft-delete) */
    @Column(name = "activo")
    private Boolean activo;

}
