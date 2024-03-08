package org.primerparcial.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(
        schema = "dbausers",
        name = "rol"
)
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    @Column(name = "rol_name")
    private String rolName;

    @Column(name = "state")
    private boolean state;

}
