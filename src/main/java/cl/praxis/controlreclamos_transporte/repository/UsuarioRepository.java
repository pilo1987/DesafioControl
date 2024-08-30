package cl.praxis.controlreclamos_transporte.repository;

import cl.praxis.controlreclamos_transporte.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByUsername(String username);
}
