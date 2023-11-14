package com.desarrollo.Spring5.repositories;

import com.desarrollo.Spring5.entities.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface EmpleadoRepository extends BaseRepository<Empleado, Long> {
  
  //Busqueda de un empleado registrado desde X fechas
    @Query(value = "SELECT * FROM empleado WHERE empleado.fecha_alta > :filtro", nativeQuery = true)
    List<Empleado> searchNativo(@Param("filtro") String filtro);
}
