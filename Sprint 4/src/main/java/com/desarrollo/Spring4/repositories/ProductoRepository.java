package com.desarrollo.Spring4.repositories;

import com.desarrollo.Spring4.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductoRepository extends BaseRepository<Producto, Long> {
     //Query nativa

    @Query(
            value = "SELECT * FROM producto WHERE producto.denominacion LIKE %:filtro%",
            nativeQuery = true
            //x defecto natQuery viene desactivado
    )
    List<Producto> searchNativo(@Param("filtro") String filtro);

    //Querys q reciben paginacion
    @Query(
            value = "SELECT * FROM producto WHERE producto.denominacion LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM producto",//permite contar la cant de paginas
            nativeQuery = true//x defecto natQuery viene desactivado
    )
    Page<Producto> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
