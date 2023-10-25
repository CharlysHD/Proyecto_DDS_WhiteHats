package com.desarrollo.Spring3.repositories;

import com.desarrollo.Spring3.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
