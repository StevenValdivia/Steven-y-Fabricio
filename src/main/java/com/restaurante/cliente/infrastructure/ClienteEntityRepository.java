package com.restaurante.cliente.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ClienteEntityRepository extends JpaRepository<ClienteEntity, Integer>
{
    @Query("SELECT a FROM ClienteEntity a LEFT JOIN FETCH a.correoEntitySet")
    List<ClienteEntity> getAll();
}