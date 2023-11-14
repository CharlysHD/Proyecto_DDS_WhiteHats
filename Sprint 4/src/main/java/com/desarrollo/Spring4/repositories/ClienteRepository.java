package com.desarrollo.Spring4.repositories;

import com.desarrollo.Spring4.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long> {

    //Busqueda de un cliente segun nombre o apellido
    @Query(value = "SELECT * FROM cliente WHERE cliente.nombre LIKE %:filtro% OR cliente.apellido LIKE %:filtro%",
            nativeQuery = true
    )
    List<Cliente> searchNativo(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM cliente WHERE cliente.nombre LIKE %:filtro% OR cliente.apellido LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM cliente",
            nativeQuery = true
    )
    Page<Cliente> searchNativo(@Param("filtro") String filtro, Pageable pageable);

    @Query("SELECT c, COUNT(o) as pedidos, Sum(o.total) as total " +
            "FROM Cliente c " +
            "JOIN Pedido o ON c.id = o.cliente.id " +
            "GROUP BY c.id " +
            "ORDER BY pedidos desc")
    List<Object> getTop5UsersOrders(Pageable pageable);

}
