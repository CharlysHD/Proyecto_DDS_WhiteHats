package com.desarrollo.Spring5.services;

import com.desarrollo.Spring5.entities.DetallePedido;
import com.desarrollo.Spring5.repositories.BaseRepository;
import com.desarrollo.Spring5.repositories.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoServiceImpl extends BaseServiceImpl<DetallePedido, Long> implements DetallePedidoService{
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;
    public DetallePedidoServiceImpl(BaseRepository<DetallePedido, Long> baseRepository) {super(baseRepository);}
}
