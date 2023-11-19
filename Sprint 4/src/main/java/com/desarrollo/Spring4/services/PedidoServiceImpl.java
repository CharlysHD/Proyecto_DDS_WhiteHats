package com.desarrollo.Spring4.services;

import com.desarrollo.Spring4.entities.Pedido;
import com.desarrollo.Spring4.enums.EstadoPedido;
import com.desarrollo.Spring4.repositories.BaseRepository;
import com.desarrollo.Spring4.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;
    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Pedido> search(String filtro, EstadoPedido estado) throws Exception {
        try{
            List<Pedido> pedidos= pedidoRepository.searchNativo(filtro, estado);
            return pedidos;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public List<Pedido> search(String desde, String hasta) throws Exception {
        try{
            List<Pedido> pedidos= pedidoRepository.searchNativo2(desde, hasta);
            return pedidos;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
