package com.desarrollo.Spring3.services;

import com.desarrollo.Spring3.entities.Venta;
import com.desarrollo.Spring3.repositories.BaseRepository;
import com.desarrollo.Spring3.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceImpl extends BaseServiceImpl<Venta, Long> implements VentaService{
    @Autowired
    private VentaRepository ventaRepository;
    public VentaServiceImpl(BaseRepository<Venta, Long> baseRepository) {
        super(baseRepository);
    }
}
