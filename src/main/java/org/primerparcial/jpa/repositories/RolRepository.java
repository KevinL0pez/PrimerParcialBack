package org.primerparcial.jpa.repositories;

import org.primerparcial.jpa.entities.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Long> {
    @Query(
            value="SELECT r FROM RolEntity r WHERE r.idRol=:idRol AND r.idRol IS NOT NULL"
    )
    RolEntity getRolById(Long idRol);
}
