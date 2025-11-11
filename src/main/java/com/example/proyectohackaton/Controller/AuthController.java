package com.example.proyectohackaton.Controller;

import com.example.proyectohackaton.Entity.Usuario;
import com.example.proyectohackaton.Entity.SolicitudMantenimiento;
import com.example.proyectohackaton.Service.UsuarioService;
import com.example.proyectohackaton.Service.SolicitudMantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SolicitudMantenimientoService solicitudMantenimientoService;

    /**
     * Página de inicio pública
     */
    @GetMapping("")
    public String index() {
        return "index";
    }

    /**
     * Página de login pública
     */
    @GetMapping("login")
    public String login() {
        return "login";
    }

    /**
     * Dashboard después del inicio de sesión
     */
    @GetMapping("dashboard")
    public String dashboard(Model model) {
        Usuario usuarioActual = obtenerUsuarioLogueado();
        model.addAttribute("usuario", usuarioActual);
        model.addAttribute("roles", usuarioActual.getRoles());
        return "dashboard";
    }

    /**
     * Página Solicitante
     */
    @GetMapping("solicitante")
    public String solicitante(Model model) {
        Usuario usuarioActual = obtenerUsuarioLogueado();
        model.addAttribute("usuario", usuarioActual);
        model.addAttribute("roles", usuarioActual.getRoles());
        return "solicitante";
    }

    /**
     * Formulario de abrir ticket
     */
    @GetMapping("abrirTicket")
    public String abrirTicketForm(Model model) {
        Usuario usuarioActual = obtenerUsuarioLogueado();
        model.addAttribute("usuario", usuarioActual);
        model.addAttribute("solicitud", new SolicitudMantenimiento());
        return "abrirTicket";
    }

    /**
     * Procesar creación de ticket
     */
    @PostMapping("abrirTicket")
    public String crearSolicitud(@ModelAttribute SolicitudMantenimiento solicitud) {
        Usuario usuarioActual = obtenerUsuarioLogueado();
        solicitud.setUsuario(usuarioActual);
        solicitudMantenimientoService.crearSolicitud(solicitud);
        return "redirect:/solicitudes?exito=true";
    }

    /**
     * Ver solicitudes del usuario
     */
    @GetMapping("solicitudes")
    public String verSolicitudes(Model model) {
        Usuario usuarioActual = obtenerUsuarioLogueado();
        model.addAttribute("usuario", usuarioActual);
        model.addAttribute("roles", usuarioActual.getRoles());
        return "solicitudes";
    }

    /**
     * Cerrar sesión (Spring Security lo gestiona, pero damos endpoint amigable)
     */
    @GetMapping("logout")
    public String logout() {
        return "redirect:/login?logout";
    }

    /**
     * Método utilitario para obtener usuario logueado desde Spring Security
     */
    private Usuario obtenerUsuarioLogueado() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return usuarioService.obtenerUsuarioPorCorreo(auth.getName()).orElse(null);
    }
}
