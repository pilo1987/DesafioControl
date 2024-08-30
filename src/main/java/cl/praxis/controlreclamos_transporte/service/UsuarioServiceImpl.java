package cl.praxis.controlreclamos_transporte.service;

import cl.praxis.controlreclamos_transporte.model.entities.Usuario;
import cl.praxis.controlreclamos_transporte.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    public Usuario findOne(int id) {
        return repository.findById(id).orElse(null);
    }


    @Override
    public boolean create(Usuario u) {

        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return repository.save(u) != null;
    }

    @Override
    public boolean update(Usuario u) {
        return repository.save(u) != null;
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
