package com.desarrollo.Spring3.repositories;

import com.desarrollo.Spring3.entities.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}
