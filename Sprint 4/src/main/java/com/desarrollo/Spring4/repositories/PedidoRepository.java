package com.desarrollo.Spring4.repositories;

import com.desarrollo.Spring4.entities.Pedido;
import com.desarrollo.Spring4.enums.EstadoPedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoRepository extends BaseRepository<Pedido,Long>{
    @Query(
            value = "SELECT * FROM pedido WHERE pedido.tipo_envio LIKE %:filtro% OR pedido.estado_pedido LIKE %:estado%",
            nativeQuery = true
    )
    List<Pedido> searchNativo(@Param("filtro") String filtro, @Param("estado")EstadoPedido estado);

    @Query(
            value = "SELECT * FROM pedido WHERE pedido.fecha_pedido >= %:desde% AND pedido.fecha_pedido <= %:hasta%",
            nativeQuery = true
    )
    List<Pedido> searchNativo2(@Param("desde") String desde, @Param("hasta")String hasta);
}
