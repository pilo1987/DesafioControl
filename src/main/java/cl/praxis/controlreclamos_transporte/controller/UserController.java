package cl.praxis.controlreclamos_transporte.controller;

import cl.praxis.controlreclamos_transporte.model.entities.Usuario;
import cl.praxis.controlreclamos_transporte.service.RolService;
import cl.praxis.controlreclamos_transporte.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UsuarioService usuarioService;
    private final RolService rolService;

    public UserController(UsuarioService usuarioService, RolService rolService) {
        this.usuarioService = usuarioService;
        this.rolService = rolService;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("users", usuarioService.findAll());
        return "userList";
    }
    @GetMapping("/new")
    public String create(Model model){

        model.addAttribute("roles", rolService.findAll());
        return "newUser";
    }

    @PostMapping
    public String update(@ModelAttribute Usuario usuario){
        boolean result = usuarioService.update(usuario);
        return "redirect:/users";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute Usuario usuario){
        boolean result = usuarioService.create(usuario);

        return "redirect:/users";
    }
    @GetMapping("/{id}/del")
    public String delete(@PathVariable("id") int id){
        boolean result = usuarioService.delete(id);

        return "redirect:/users";
    }
}
