package com.desarrollo.Spring4.repositories;

import com.desarrollo.Spring4.entities.ArticuloInsumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo, Long> {

    //Query que trae todos los datos de articuloInsumo segun su denominacion
    @Query(
            value = "SELECT * FROM articuloinsumo WHERE articuloinsumo.stock_minimo < :filtro",
            nativeQuery = true
    )
    List<ArticuloInsumo> searchNativo(@Param("filtro") String filtro);

    //Querys q reciben paginacion
    @Query(
            value = "SELECT * FROM articuloinsumo WHERE articuloinsumo.denominacion LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM articuloinsumo",//permite contar la cant de paginas
            nativeQuery = true//x defecto natQuery viene desactivado
    )
    Page<ArticuloInsumo> searchNativo(@Param("filtro") String filtro, Pageable pageable);

}
