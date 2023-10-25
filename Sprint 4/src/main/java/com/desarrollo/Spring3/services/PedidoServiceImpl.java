package com.desarrollo.Spring3.services;

import com.desarrollo.Spring3.entities.Pedido;
import com.desarrollo.Spring3.repositories.BaseRepository;
import com.desarrollo.Spring3.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService{
    @Autowired
    private PedidoRepository pedidoRepository;
    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository) {
        super(baseRepository);
    }
}
