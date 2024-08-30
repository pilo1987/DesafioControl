package cl.praxis.controlreclamos_transporte.service;

import cl.praxis.controlreclamos_transporte.model.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
    Usuario findOne(int id);
    boolean create(Usuario u);
    boolean update(Usuario u);
    boolean delete(int id);
}
