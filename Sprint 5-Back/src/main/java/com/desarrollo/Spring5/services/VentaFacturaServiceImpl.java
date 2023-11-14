package com.desarrollo.Spring5.services;

import com.desarrollo.Spring5.entities.VentaFactura;
import com.desarrollo.Spring5.repositories.BaseRepository;
import com.desarrollo.Spring5.repositories.VentaFacturaRepository;
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
