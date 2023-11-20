package com.desarrollo.Spring5.repositories;

import com.desarrollo.Spring5.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends BaseRepository<Producto, Long> {

    //Query nativa que busca todos los productos segun su denominacion
    @Query(
            value = "SELECT * FROM producto WHERE producto.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    List<Producto> searchNativo(@Param("filtro") String filtro);

    //Querys q reciben paginacion
    @Query(
            value = "SELECT * FROM producto WHERE producto.denominacion LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM producto",//permite contar la cant de paginas
            nativeQuery = true//x defecto natQuery viene desactivado
    )
    Page<Producto> searchNativo(@Param("filtro") String filtro, Pageable pageable);

    //Top 5 productos que aparezcan en un detallefactura
    @Query("SELECT p, COUNT(o) as pedidos, Sum(o.cantidad) as total " +
            "FROM Producto p " +
            "JOIN DetalleFactura o ON p.id = o.producto.id " +
            "GROUP BY p.id " +
            "ORDER BY pedidos desc")
    List<Object>getTop5Products(Pageable pageable);
}
