package com.desarrollo.Spring4.services;

import com.desarrollo.Spring4.entities.Pedido;
import com.desarrollo.Spring4.enums.EstadoPedido;

import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long>{
    List<Pedido> search(String filtro, EstadoPedido estado) throws Exception;

    List<Pedido> search(String desde, String hasta) throws Exception;
}
