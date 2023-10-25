package com.desarrollo.Spring3.services;

import com.desarrollo.Spring3.entities.Factura;
import com.desarrollo.Spring3.repositories.BaseRepository;
import com.desarrollo.Spring3.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura, Long> implements FacturaService{
    @Autowired
    private FacturaRepository facturaRepository;
    public FacturaServiceImpl(BaseRepository<Factura, Long> baseRepository) {
        super(baseRepository);
    }
}
