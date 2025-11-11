package com.example.proyectohackaton.Config;

import com.example.proyectohackaton.Entity.Usuario;
import com.example.proyectohackaton.Entity.Rol;
import com.example.proyectohackaton.Entity.NombreRol;
import com.example.proyectohackaton.Repository.UsuarioRepository;
import com.example.proyectohackaton.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Inicializador de datos de prueba
 * Se ejecuta automáticamente al iniciar la aplicación
 * Crea datos de prueba si no existen en la BD
 */
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║    Inicializando datos de prueba...                   ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝");

        try {
            // 1. Crear Roles
            crearRolesDelSistema();

            // 2. Crear Usuarios de Prueba
            crearUsuariosDelSistema();

            System.out.println("╔═══════════════════════════════════════════════════════╗");
            System.out.println("║    ✅ Datos de prueba cargados correctamente          ║");
            System.out.println("║    📝 Prueba con: juan.garcia@example.com            ║");
            System.out.println("║    🔐 Contraseña: password123                         ║");
            System.out.println("╚═══════════════════════════════════════════════════════╝");
        } catch (Exception ex) {
            // Registrar el error pero permitir que la aplicación continúe iniciando
            System.err.println("❌ Error al inicializar datos de prueba: " + ex.getMessage());
            ex.printStackTrace();
            System.err.println("⚠️  La aplicación continuará arrancando, pero revisa la conexión a la base de datos.");
        }
    }

    /**
     * Crea los roles del sistema si no existen
     */
    private void crearRolesDelSistema() {
        NombreRol[] rolesNombres = {
            NombreRol.ADMINISTRADOR,
            NombreRol.TECNICO,
            NombreRol.EMPLEADO
        };

        for (NombreRol nombreRol : rolesNombres) {
            try {
                Optional<Rol> rolExistente = rolRepository.findByNombre(nombreRol);
                
                if (rolExistente.isEmpty()) {
                    Rol nuevoRol = new Rol();
                    nuevoRol.setNombre(nombreRol);
                    rolRepository.save(nuevoRol);
                    System.out.println("✅ Rol creado: " + nombreRol);
                }
            } catch (Exception e) {
                System.out.println("⚠️  Error al crear rol " + nombreRol + ": " + e.getMessage());
            }
        }
    }

    /**
     * Crea los usuarios de prueba si no existen
     */
    private void crearUsuariosDelSistema() {
        // Obtener roles
        Optional<Rol> rolEmpleado = rolRepository.findByNombre(NombreRol.EMPLEADO);
        Optional<Rol> rolTecnico = rolRepository.findByNombre(NombreRol.TECNICO);
        Optional<Rol> rolAdministrador = rolRepository.findByNombre(NombreRol.ADMINISTRADOR);

        // Usuario 1: Empleado (Solicitante)
        crearUsuarioSiNoExiste(
            "Juan",
            "García",
            "juan.garcia@example.com",
            "password123",
            "3001234567",
            "Solicitante",
            rolEmpleado
        );

        // Usuario 2: Técnico
        crearUsuarioSiNoExiste(
            "Carlos",
            "Martínez",
            "carlos.martinez@example.com",
            "password123",
            "3009876543",
            "Técnico de Mantenimiento",
            rolTecnico
        );

        // Usuario 3: Técnico (Jefe)
        crearUsuarioSiNoExiste(
            "María",
            "López",
            "maria.lopez@example.com",
            "password123",
            "3005555555",
            "Jefe de Mantenimiento",
            rolTecnico
        );

        // Usuario 4: Empleado (Oficina)
        crearUsuarioSiNoExiste(
            "Pedro",
            "Rodríguez",
            "pedro.rodriguez@example.com",
            "password123",
            "3004444444",
            "Personal de Oficina",
            rolEmpleado
        );

        // Usuario 5: Administrador
        crearUsuarioSiNoExiste(
            "Admin",
            "Sistema",
            "admin@example.com",
            "admin123",
            "3003333333",
            "Administrador del Sistema",
            rolAdministrador
        );
    }

    /**
     * Crea un usuario si no existe en la base de datos
     */
    private void crearUsuarioSiNoExiste(String nombre, String apellido, String correo, 
                                       String contrasena, String celular, String cargo,
                                       Optional<Rol> rol) {
        // Verificar si el usuario ya existe
        Optional<Usuario> usuarioExistente = usuarioRepository.findByCorreo(correo);
        
        if (usuarioExistente.isEmpty() && rol.isPresent()) {
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombre(nombre);
            nuevoUsuario.setApellido(apellido);
            nuevoUsuario.setCorreo(correo);
            nuevoUsuario.setContrasena(contrasena); // En texto plano para desarrollo
            nuevoUsuario.setCelular(celular);
            nuevoUsuario.setActivo(true);
            nuevoUsuario.setDescripcionCargo(cargo);
            
            // Asignar rol
            Set<Rol> roles = new HashSet<>();
            roles.add(rol.get());
            nuevoUsuario.setRoles(roles);
            
            usuarioRepository.save(nuevoUsuario);
            System.out.println("✅ Usuario creado: " + correo + " (" + cargo + ")");
        } else if (usuarioExistente.isPresent()) {
            System.out.println("ℹ️  Usuario ya existe: " + correo);
        }
    }
}
