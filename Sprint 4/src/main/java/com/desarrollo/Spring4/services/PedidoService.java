package com.desarrollo.Spring4.services;

import com.desarrollo.Spring4.entities.Pedido;
import com.desarrollo.Spring4.entities.Usuario;

import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long>{

    List<Pedido> search(String filtro) throws Exception;
}
