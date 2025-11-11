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

                        // Rutas accesibles solo para usuarios autenticados
                        .requestMatchers("/solicitante", "/abrirTicket", "/solicitudes").authenticated()
                        .requestMatchers("/dashboard").authenticated()

                        // Cualquier otra ruta requiere autenticación
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")                // Página de login personalizada
                        .loginProcessingUrl("/login")       // Procesamiento del formulario
                        .usernameParameter("correo")        // Nombre del campo del correo
                        .passwordParameter("contrasena")    // Nombre del campo contraseña
                        .defaultSuccessUrl("/dashboard", true) // Redirección si el login es correcto
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
}

