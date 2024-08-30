package cl.praxis.controlreclamos_transporte.model.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="t_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="usuario_id")
    private int id;
    private String username;
    private String nombre;
    private String apellido;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name="t_user_role",

            joinColumns = @JoinColumn(name="usuario_id", referencedColumnName = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name="rol_id", referencedColumnName = "rol_id"))
    List<Rol> roles;

}
