package cl.praxis.controlreclamos_transporte.service;

import cl.praxis.controlreclamos_transporte.model.entities.Rol;

import java.util.List;

public interface RolService {
    List<Rol> findAll();
    Rol findOne(int id);
    boolean create(Rol r);
    boolean update(Rol r);
    boolean delete(int id);
}
