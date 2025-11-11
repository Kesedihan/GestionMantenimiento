package com.example.proyectohackaton.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Password encoder para desarrollo: NO_OP (texto plano).
     * NOTA: Solo para desarrollo. En producción usa BCryptPasswordEncoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * Authentication provider que usa UserDetailsService y el PasswordEncoder.
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    /**
     * Configuración de seguridad y control de accesos
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, DaoAuthenticationProvider authProvider) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF para evitar errores en formularios
                .authorizeHttpRequests(auth -> auth
                        // Recursos estáticos permitidos sin autenticación
                        .requestMatchers("/", "/login", "/css/**", "/js/**", "/images/**", "/static/**").permitAll()

                        // Rutas por rol
                        .requestMatchers("/solicitante", "/abrirTicket", "/solicitudes").hasRole("EMPLEADO")
                        // Operaciones del técnico/operario
                        .requestMatchers("/operario", "/asignar", "/estadoTicket").hasRole("TECNICO")
                        // Dashboard y acciones administrativas
                        .requestMatchers("/dashboard", "/admin/**").hasRole("ADMINISTRADOR")

                        // Cualquier otra ruta requiere autenticación
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")                // Página de login personalizada
                        .loginProcessingUrl("/login")       // Procesamiento del formulario
                        .usernameParameter("correo")        // Nombre del campo del correo
                        .passwordParameter("contrasena")    // Nombre del campo contraseña
                        // Usamos un success handler para redirigir según el rol asignado
                        .successHandler(myAuthenticationSuccessHandler())
                        .failureUrl("/login?error=true")    // En caso de error en autenticación
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .permitAll()
                );

        // Registrar el authentication provider (usa nuestro UserDetailsService)
        http.authenticationProvider(authProvider);

        return http.build();
    }

    /**
     * Handler para redirigir al usuario a la vista correspondiente según su rol.
     */
    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
        return (request, response, authentication) -> {
            boolean isAdmin = authentication.getAuthorities().stream()
                    .anyMatch(a -> a.getAuthority().equals("ROLE_ADMINISTRADOR"));
            boolean isTecnico = authentication.getAuthorities().stream()
                    .anyMatch(a -> a.getAuthority().equals("ROLE_TECNICO"));
            boolean isEmpleado = authentication.getAuthorities().stream()
                    .anyMatch(a -> a.getAuthority().equals("ROLE_EMPLEADO"));

            if (isAdmin) {
                response.sendRedirect(request.getContextPath() + "/dashboard");
            } else if (isTecnico) {
                response.sendRedirect(request.getContextPath() + "/operario");
            } else if (isEmpleado) {
                response.sendRedirect(request.getContextPath() + "/solicitante");
            } else {
                response.sendRedirect(request.getContextPath() + "/");
            }
        };
    }
}