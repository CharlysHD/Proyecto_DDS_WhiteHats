package com.desarrollo.Spring3.repositories;

import com.desarrollo.Spring3.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
