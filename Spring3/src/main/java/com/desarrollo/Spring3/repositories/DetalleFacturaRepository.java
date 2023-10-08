package com.desarrollo.Spring3.repositories;

import com.desarrollo.Spring3.entities.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Long> {
}
