package com.desarrollo.Spring4.services;

import com.desarrollo.Spring4.entities.Factura;
import com.desarrollo.Spring4.repositories.BaseRepository;
import com.desarrollo.Spring4.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura, Long> implements FacturaService{
    @Autowired
    private FacturaRepository facturaRepository;
    public FacturaServiceImpl(BaseRepository<Factura, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Factura> search(String filtro) throws Exception {
        try{
            List<Factura> facturas= facturaRepository.searchNativo(filtro);
            return facturas;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
