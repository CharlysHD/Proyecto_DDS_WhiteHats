package com.desarrollo.Spring4.repositories;

import com.desarrollo.Spring4.entities.Factura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacturaRepository extends BaseRepository<Factura, Long> {

    //Busqueda de facturas segun su fecha de alta
    @Query(value = "SELECT * FROM factura WHERE factura.fecha_alta LIKE %:filtro%", nativeQuery = true)
    List<Factura> searchNativo(@Param("filtro")String filtro);
}
