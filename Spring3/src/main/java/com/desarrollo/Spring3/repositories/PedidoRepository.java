package com.desarrollo.Spring3.repositories;

import com.desarrollo.Spring3.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long>{
}
