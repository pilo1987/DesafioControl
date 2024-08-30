package cl.praxis.controlreclamos_transporte.repository;

import cl.praxis.controlreclamos_transporte.model.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {
}
