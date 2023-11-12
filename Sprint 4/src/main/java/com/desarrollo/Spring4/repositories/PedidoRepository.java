package com.desarrollo.Spring4.repositories;

import com.desarrollo.Spring4.entities.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoRepository extends BaseRepository<Pedido,Long>{

    @Query(value = "SELECT * FROM pedido WHERE pedido.tipo_envio LIKE %:filtro%",
            nativeQuery = true
    )
    List<Pedido> searchNativo(@Param("filtro") String filtro);
}
