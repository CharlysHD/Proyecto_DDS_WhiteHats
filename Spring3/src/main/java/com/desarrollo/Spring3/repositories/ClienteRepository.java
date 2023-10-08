package com.desarrollo.Spring3.repositories;

import com.desarrollo.Spring3.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
