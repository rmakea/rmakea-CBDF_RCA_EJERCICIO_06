package com.upiiz.cam.repositories;

import com.upiiz.cam.models.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    // Aquí puedes agregar consultas personalizadas
    // @Query
}
