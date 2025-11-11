package com.example.proyectohackaton.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor     // Genera el constructor con los paremetros
@NoArgsConstructor      // Genera el constructor sin los parametros
@Builder                // Con esto, lombok implementa el patron de diseño Builder para construir objetos de esta clase
@Entity
@Table(name = "categoria")
public class Categoria {

    /** Identificador único de la categoria */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;


    /** Nombre de la categoria */
    @Column(nullable = false, length = 100)
    private String nombre;


    /** Descripcion de la categoria */
    @Column(columnDefinition = "TEXT")
    private String descripcion;

    /** Indica si la categoria está activa (soft-delete) */
    @Column(name = "activo")
    private Boolean activo;

}
