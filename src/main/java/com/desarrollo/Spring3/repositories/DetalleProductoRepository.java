package com.desarrollo.Spring3.repositories;

import com.desarrollo.Spring3.entities.DetalleProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleProductoRepository extends JpaRepository<DetalleProducto,Long> {
}
