package com.desarrollo.Spring3.services;

import com.desarrollo.Spring3.entities.DetalleFactura;
import com.desarrollo.Spring3.repositories.BaseRepository;
import com.desarrollo.Spring3.repositories.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleFacturaServiceImpl extends BaseServiceImpl<DetalleFactura, Long> implements DetalleFacturaService {
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;
    public DetalleFacturaServiceImpl(BaseRepository<DetalleFactura, Long> baseRepository){
        super(baseRepository);
    }
}
