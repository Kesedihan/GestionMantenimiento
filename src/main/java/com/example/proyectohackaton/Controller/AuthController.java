package com.example.proyectohackaton.Controller;

import com.example.proyectohackaton.Entity.Usuario;
import com.example.proyectohackaton.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired(required = false)
    private PasswordEncoder passwordEncoder;

    /**
     * Muestra la página de inicio
     */
    @GetMapping("")
    public String index(Model model) {
        return "index";
    }

    /**
     * Muestra la página de login
     */
    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    /**
     * Procesa el login del usuario
     */
    @PostMapping("login")
    public String procesarLogin(@RequestParam String correo, 
                               @RequestParam String contrasena,
                               HttpSession session,
                               Model model) {
        
        Optional<Usuario> usuarioOpt = usuarioService.obtenerUsuarioPorCorreo(correo);
        
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            
            // Validar contraseña
            boolean passwordValida = false;
            if (passwordEncoder != null) {
                passwordValida = passwordEncoder.matches(contrasena, usuario.getContrasena());
            } else {
                // Fallback para desarrollo sin BCrypt configurado
                passwordValida = usuario.getContrasena().equals(contrasena);
            }
            
            if (passwordValida && usuario.getActivo()) {
                session.setAttribute("usuarioActual", usuario);
                return "redirect:/dashboard";
            }
        }
        
        model.addAttribute("error", "Credenciales inválidas o usuario inactivo");
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    /**
     * Cierra sesión del usuario
     */
    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    /**
     * Muestra el dashboard después del login
     */
    @GetMapping("dashboard")
    public String dashboard(HttpSession session, Model model) {
        Usuario usuarioActual = (Usuario) session.getAttribute("usuarioActual");
        
        if (usuarioActual == null) {
            return "redirect:/login";
        }
        
        model.addAttribute("usuario", usuarioActual);
        model.addAttribute("roles", usuarioActual.getRoles());
        
        return "dashboard";
    }
}
