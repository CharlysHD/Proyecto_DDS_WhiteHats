package com.desarrollo.Spring3.repositories;

import com.desarrollo.Spring3.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}
