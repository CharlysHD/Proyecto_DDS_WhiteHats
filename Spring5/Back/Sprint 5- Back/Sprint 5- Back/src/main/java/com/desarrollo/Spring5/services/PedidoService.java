package com.desarrollo.Spring5.services;

import com.desarrollo.Spring5.entities.Pedido;

import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long>{
    List<Pedido> search(String filtro) throws Exception;
}
