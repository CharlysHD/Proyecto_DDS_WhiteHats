package com.desarrollo.Spring4.repositories;

import com.desarrollo.Spring4.entities.Venta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VentaRepository extends BaseRepository<Venta, Long> {

    //Busca todas las ventas igual a un codigoVenta
    @Query(value = "SELECT * FROM venta WHERE venta.codigo_venta = %:filtro%", nativeQuery = true)
    List<Venta> searchNativo(@Param("filtro")String filtro);
}
