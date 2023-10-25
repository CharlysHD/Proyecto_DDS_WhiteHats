package com.desarrollo.Spring4.services;

import com.desarrollo.Spring4.entities.VentaFactura;
import com.desarrollo.Spring4.repositories.BaseRepository;
import com.desarrollo.Spring4.repositories.VentaFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaFacturaServiceImpl extends BaseServiceImpl<VentaFactura, Long> implements VentaFacturaService{
    @Autowired
    private VentaFacturaRepository ventaFacturaRepository;
    public VentaFacturaServiceImpl(BaseRepository<VentaFactura, Long> baseRepository) {
        super(baseRepository);
    }
}
