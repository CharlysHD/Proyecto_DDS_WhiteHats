package com.desarrollo.Spring5.services;

import com.desarrollo.Spring5.entities.Venta;
import com.desarrollo.Spring5.repositories.BaseRepository;
import com.desarrollo.Spring5.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImpl extends BaseServiceImpl<Venta, Long> implements VentaService{
    @Autowired
    private VentaRepository ventaRepository;
    public VentaServiceImpl(BaseRepository<Venta, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Venta> search(String filtro) throws Exception {
        try{
            List<Venta> ventas= ventaRepository.searchNativo(filtro);
            return ventas;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
