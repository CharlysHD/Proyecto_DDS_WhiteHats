package com.desarrollo.Spring4.repositories;

import com.desarrollo.Spring4.entities.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpleadoRepository extends BaseRepository<Empleado, Long> {

    //Busqueda de un empleado registrado desde X fechas
    @Query(value = "SELECT * FROM empleado WHERE empleado.fecha_alta BETWEEN :inicio AND :fin", nativeQuery = true)
    List<Empleado> searchNativo(@Param("inicio") String inicio, @Param("fin") String fin );
}