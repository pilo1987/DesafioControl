package cl.praxis.controlreclamos_transporte.service;

import cl.praxis.controlreclamos_transporte.model.entities.Rol;
import cl.praxis.controlreclamos_transporte.repository.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    private final RolRepository repository;

    public RolServiceImpl(RolRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Rol> findAll() {
        return repository.findAll();
    }

    @Override
    public Rol findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean create(Rol r) {
        return repository.save(r) != null;
    }

    @Override
    public boolean update(Rol r) {
        return repository.save(r) != null;
    }

    @Override
    public boolean delete(int id) {
        boolean exist = repository.existsById(id);
        if (exist){
            repository.deleteById(id);
        }
        return exist;
    }
}
