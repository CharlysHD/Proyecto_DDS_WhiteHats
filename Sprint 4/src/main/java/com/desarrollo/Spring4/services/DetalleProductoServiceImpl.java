package com.desarrollo.Spring4.services;

import com.desarrollo.Spring4.entities.DetalleProducto;
import com.desarrollo.Spring4.repositories.BaseRepository;
import com.desarrollo.Spring4.repositories.DetalleProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleProductoServiceImpl extends BaseServiceImpl<DetalleProducto, Long> implements DetalleProductoService{
    @Autowired
    private DetalleProductoRepository detalleProductoRepository;
    public DetalleProductoServiceImpl(BaseRepository<DetalleProducto, Long> baseRepository) {super(baseRepository);}
}
