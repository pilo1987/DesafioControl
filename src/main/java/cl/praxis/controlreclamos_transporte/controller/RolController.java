package cl.praxis.controlreclamos_transporte.controller;

import cl.praxis.controlreclamos_transporte.model.entities.Rol;
import cl.praxis.controlreclamos_transporte.service.RolService;
import cl.praxis.controlreclamos_transporte.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RolController {
    private final RolService rolService;
    private final UsuarioService usuarioService;

    public RolController(RolService rolService, UsuarioService usuarioService) {
        this.rolService = rolService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("roles", rolService.findAll());
        return "roleList";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") int id, Model model){
        model.addAttribute("roles", rolService.findOne(id));
        model.addAttribute("users", usuarioService.findAll());
        return "roleEdit";
    }

    @PostMapping
    public String update(@ModelAttribute Rol rol){
        boolean result = rolService.update(rol);
        return "redirect:/roles";
    }

    @GetMapping("/new")
    public String toCreate(){

        return "newRole";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute Rol rol){
        boolean result = rolService.create(rol);

        return "redirect:/roles";
    }
    @GetMapping("/{id}/del")
    public String delete(@PathVariable("id") int id){
        boolean result = rolService.delete(id);

        return "redirect:/roles";
    }
}
