package com.desarrollo.Spring4.services;

import com.desarrollo.Spring4.entities.DetallePedido;
import com.desarrollo.Spring4.repositories.BaseRepository;
import com.desarrollo.Spring4.repositories.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoServiceImpl extends BaseServiceImpl<DetallePedido, Long> implements DetallePedidoService{
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;
    public DetallePedidoServiceImpl(BaseRepository<DetallePedido, Long> baseRepository) {super(baseRepository);}
}
