package com.desarrollo.Spring3.repositories;

import com.desarrollo.Spring3.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
