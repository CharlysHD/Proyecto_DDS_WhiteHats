package com.desarrollo.Spring3.repositories;

import com.desarrollo.Spring3.entities.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long> {
}
